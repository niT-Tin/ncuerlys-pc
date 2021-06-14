package Demo1;

import cn.edu.scau.biubiusuisui.annotation.FXController;
import cn.edu.scau.biubiusuisui.annotation.FXRedirect;
import cn.edu.scau.biubiusuisui.annotation.FXWindow;
import cn.edu.scau.biubiusuisui.entity.FXBaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import org.teasoft.bee.erlys.gets.GetMyWish;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactory;
import pojo.Administrator;
import pojo.Userinfo;

import java.util.List;

@FXWindow(title = "具体信息页面" )
@FXController(path="fxml/AthInformation.fxml")
public class ControlAthInformation extends FXBaseController {
    @FXRedirect
    public String Athexit(){
        this.closeStage();
        return "ControlMainsurface";
    }
//    @FXRedirect
//    public   String Athsavebtn(){
//        return "ControlMainsurface";
//    }
    SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

    @FXML
    private TextArea Athidfile;

    @FXML
    private TextArea Athnamefile;

    @FXML
    private TextArea Athaddressfile;
    @FXML
    private TextArea Athcoachfile;
    @FXML
    private TextArea Athrelafile;
    @FXML
    private TextArea Athidcardfile;
    @FXML
    private TextArea Athschoolfile;
    @FXML
    private TextArea Athguardianfile;
    @FXML
    private TextArea Athcontactfile;


    @Override
    public void onShow(){//throws Exception
        Athidfile.setEditable(false);
        Athidfile.clear();
        Athaddressfile.clear();
        Athcoachfile.clear();
        Athrelafile.clear();
        Athidcardfile.clear();
        Athschoolfile.clear();
        Athguardianfile.clear();
        Athcontactfile.clear();
//        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        Userinfo userinfo = GetMyWish.selectByAccount(new Userinfo(), String.valueOf(this.getParam().get("account")));
        if(userinfo == null){
            new Alert(Alert.AlertType.ERROR, "账户不存在",
                    new ButtonType("确定", ButtonBar.ButtonData.YES)).show();
        }else{
            Athnamefile.setText(userinfo.getName());
            Athidfile.setText(userinfo.getId() + "");
            Athaddressfile.setText(userinfo.getAddress ());
            Athcoachfile.setText(userinfo.getCoach ());
            Athrelafile.setText(userinfo.getRela());
            Athidcardfile.setText(userinfo.getIdcard());
            Athschoolfile.setText(userinfo.getSchool());
            Athguardianfile.setText(userinfo.getGuardian());
            Athcontactfile.setText(userinfo.getContact()+"");
        }
    }

    public void Athsavebtn(){
        Userinfo userinfo = new Userinfo();
       // userinfo.setId(Athidfile.getText());
        userinfo.setId(Long.parseLong(Athidfile.getText()));
        userinfo.setAddress(Athaddressfile.getText());
        userinfo.setCoach(Athcoachfile.getText());
        userinfo.setRela(Athrelafile.getText());
        userinfo.setIdcard(Athidcardfile.getText());
        userinfo.setGuardian(Athguardianfile.getText());
        userinfo.setContact(Long.parseLong(Athcontactfile.getText()));
        userinfo.setSchool(Athschoolfile.getText());

        suidRich.update(userinfo);
    }

}
