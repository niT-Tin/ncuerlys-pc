package Demo1;

import cn.edu.scau.biubiusuisui.annotation.FXController;
import cn.edu.scau.biubiusuisui.annotation.FXRedirect;
import cn.edu.scau.biubiusuisui.annotation.FXWindow;
import cn.edu.scau.biubiusuisui.entity.FXBaseController;
import cn.edu.scau.biubiusuisui.entity.FXRedirectParam;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.teasoft.bee.erlys.gets.GetMyWish;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import pojo.Userinfo;

import java.util.List;

@FXWindow(title = "登录页面",mainStage = true)
@FXController(path = "fxml/loginpage.fxml")
public class ControlLogin extends FXBaseController {

    @FXML
    private TextField accountfile;

    @FXML
    private PasswordField passwordfile;

    SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

    final String role1 = "referee";
    final String role2 = "admin";

    @FXRedirect(close = false)
    public String sigin(){

        Boolean aBoolean = GetMyWish.selectLogin(new Userinfo(), accountfile.getText(), passwordfile.getText());

        List<Userinfo> select = suidRich.select(new Userinfo(), new ConditionImpl().op("account", Op.eq, accountfile.getText())
                .and().op("password", Op.eq, passwordfile.getText()));

        if(select.isEmpty()){
            return "Dialog";
        }
        Userinfo userinfo = select.get(0);
        if(!aBoolean){
            return "Dialog";
        }else{
            this.closeStage();
            if(userinfo.getRoles().equals(role1)){
                return "Message";
            }else if(userinfo.getRoles().equals(role2)){
                return  "ControlMainsurface";
            }
        }
        return "ControlLogin";
    }
}


