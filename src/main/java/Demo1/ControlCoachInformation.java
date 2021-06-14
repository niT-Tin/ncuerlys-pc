package Demo1;

import cn.edu.scau.biubiusuisui.annotation.FXController;
import cn.edu.scau.biubiusuisui.annotation.FXRedirect;
import cn.edu.scau.biubiusuisui.annotation.FXWindow;
import cn.edu.scau.biubiusuisui.entity.FXBaseController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.teasoft.bee.erlys.gets.GetMyWish;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactory;
import pojo.Referee;
import pojo.Userinfo;

import java.util.List;

@FXWindow(title = "裁判信息")//,mainStage = true
@FXController(path="fxml/CoachInformation.fxml")

public class ControlCoachInformation extends FXBaseController {
  /*  @FXRedirect
    public String Acosavebtn(){
        return "ControlMainsurface";
    }*/
    @FXRedirect
    public String Acoexitbtn(){
        return "ControlMainsurface";
    }
    @FXML
    private TextArea  Acoidfile;
    @FXML
    private TextArea Acoaccountfile;
    @FXML
    private TextArea Acopasswordfile;

    @FXML
    private TextField Accountreachfile;

    @Override
    public void onShow() throws Exception {
        Acoidfile.clear();
        Acoaccountfile.clear();
        Acopasswordfile.clear();

        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        List<Referee> select = suidRich.select(new Referee());

        for (Referee referee : select) {
            System.out.println(referee);
        }




    }

    public void Acosavebtn(){
//        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
//        List<Referee> select = suidRich.select(new Referee());

//        GetMyWish

//        Acoidfile.setText(select.get(0).getId());
//        Acoaccountfile.setText(select.get(0).getAccount());
//        Acopasswordfile.setText(select.get(0).getPassword());

//        Acoidfile.getText()

//        suidRich.update(Referee);


    }

}
