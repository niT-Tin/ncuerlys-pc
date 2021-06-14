package Demo1;

import cn.edu.scau.biubiusuisui.annotation.FXController;
import cn.edu.scau.biubiusuisui.annotation.FXRedirect;
import cn.edu.scau.biubiusuisui.annotation.FXWindow;
import cn.edu.scau.biubiusuisui.entity.FXBaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import org.teasoft.bee.erlys.gets.GetMyWish;
import pojo.User;
import pojo.Userinfo;


@FXWindow(title = "管理员页面", resizable = false)
@FXController(path= "fxml/Administrators.fxml")

public class ControlManagePage  extends FXBaseController {
    @FXRedirect
    public String exit (){
        this.closeStage();
        return "ControlLogin";
    }

    @FXML
    private TextField AthsearchAccount;

    @FXML
    private TextField Athid;

    @FXML
    private TextField Athaccount;

    @FXML
    private TextField Athguardian;


    public void Acosavebtn(){

    }

    @FXRedirect
    public String AthSearchbtn(){
        Userinfo userinfo = new Userinfo();
        String account = AthsearchAccount.getText();
//        user.setAccount(account);
//        System.out.println(AthsearchAccount.getText());
//        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();//连接数据库
        Userinfo select = GetMyWish.selectByAccount(userinfo, account);
        System.out.println(select + "-------------------------------------------------------");
        Athid.setText(select.getId() + "");
        Athaccount.setText(select.getAccount() + "");
//        Athguardian.setText(select.get);
        if(select == null){
            new Alert(Alert.AlertType.ERROR,"输入的账号错误，错误",
                    new ButtonType("确定", ButtonBar.ButtonData.YES)).show();
            return "";
        }else{//获得该学生的所有信息

            return "Controller1";
        }

    }




}
