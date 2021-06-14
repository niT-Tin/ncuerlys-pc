package Demo1;

import cn.edu.scau.biubiusuisui.annotation.FXController;
import cn.edu.scau.biubiusuisui.annotation.FXRedirect;
import cn.edu.scau.biubiusuisui.annotation.FXWindow;
import cn.edu.scau.biubiusuisui.entity.FXBaseController;
import cn.edu.scau.biubiusuisui.entity.FXRedirectParam;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import org.teasoft.bee.erlys.gets.GetMyWish;
import org.teasoft.bee.getData.SuidRichData;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactory;
import pojo.Administrator;
import pojo.Referee;
import pojo.User;
import pojo.Userinfo;
import util.UserInfoUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@FXWindow(title = "管理员页面", preWidth = 1250 , resizable = false)//,mainStage = true/*,mainStage = true*/
@FXController(path="fxml/MainControlSurface.fxml")
public class ControlMainsurface extends FXBaseController {
   SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
   Userinfo userinfo = GetMyWish.selectByAccount(new Userinfo(), String.valueOf(this.getParam().get("account")));

    static int i = 0;

    @FXML
    private FlowPane flw1;

    @FXML
    private TableView<Userinfo> tbv;

    @FXML
    private TableView<Userinfo> tbv1;

    @FXML
    private TextField Accountreachfile;

    @FXML
    private TableColumn<Userinfo, String> c1;

    @FXML
    private TableColumn<Userinfo, String> c2;

    @FXML
    private TableColumn<Userinfo, String> c3;

    @FXML
    private TableColumn<Userinfo, String> c4;

    @FXML
    private TableColumn<Userinfo, String> c5;

    @FXML
    private TableColumn<Userinfo, String> c6;

    @FXML
    private TableColumn<Userinfo, String> c7;

    @FXML
    private TableColumn<Userinfo, String> c01;

    @FXML
    private TableColumn<Userinfo, String> c11;

    @FXML
    private TableColumn<Userinfo, String> c12;

    @FXML
    private TableColumn<Userinfo, String> c13;

    @FXML
    private TableColumn<Userinfo, String> c14;

    @FXML
    private TableColumn<Userinfo, String> c15;

    @FXML
    private TableColumn<Userinfo, String> c16;

    @FXML
    private TableColumn<Userinfo, String> c17;


    @FXML
    private FlowPane flw3;

    @FXRedirect
    public String exit (){
        this.closeStage();
        return "ControlLogin";
    }

    @FXRedirect(close = false)//跳转到两个页面
    public FXRedirectParam ReachAccountbtn(){
        Userinfo userinfo = GetMyWish.selectByAccount(new Userinfo(), Accountreachfile.getText());
//        System.out.println(userinfo);
        if(userinfo == null){
//            new Alert(Alert.AlertType.ERROR, "用户名不正确",
//                    new ButtonType("确定", ButtonBar.ButtonData.YES)).show();
            return toDialog();
        }else{
            FXRedirectParam params = new FXRedirectParam("ControlAthInformation");
            //FXRedirectParam parm = new FXRedirectParam("ControlCoachInformation");

          //  if();
            params.addParam("account", userinfo.getAccount());
           //parm.addParam("account",userinfo.getAccount());
           // if()
            return params;
          //  else return parm;
//            return "ControlAthInformation";
        }
    }

    @FXRedirect(close = false)
    public FXRedirectParam toDialog(){
        return new FXRedirectParam("Dialog");
    }


    @FXML
    private TextArea Admaccountfile;

    @FXML
    private TextArea Admidfile;

    @FXML
    private TextArea Admpasswordfile;

    @FXML
    private Tab AdmInformation;



    final String role1 = "admin";
    final String role2 = "player";
    final String role3 = "referee";

    public void athpanef(){


//        flw1.getChildren().clear();
        List<Userinfo> users = SuidRichData.selectAll(new Userinfo());
        List<Userinfo> collect = users.stream()
                .filter(user -> role2.equals(user.getRoles()))
                .collect(Collectors.toList());


        ObservableList<Userinfo> list = FXCollections.observableList(collect);
        c01.setCellValueFactory(new PropertyValueFactory("account"));
        c11.setCellValueFactory(new PropertyValueFactory("idcard"));
        c12.setCellValueFactory(new PropertyValueFactory("address"));
        c13.setCellValueFactory(new PropertyValueFactory("school"));
        c14.setCellValueFactory(new PropertyValueFactory("coach"));
        c15.setCellValueFactory(new PropertyValueFactory("guardian"));
        c16.setCellValueFactory(new PropertyValueFactory("rela"));
        c17.setCellValueFactory(new PropertyValueFactory("contact"));
        tbv1.setItems(list);
        tbv1.setEditable(false);

    }

    public void  Acopanef(){

        List<Userinfo> users3 = SuidRichData.selectAll(new Userinfo());
        List<Userinfo> collect = users3.stream()
                      .filter(users1 -> role3.equals(users1.getRoles()))
                      .collect(Collectors.toList());


        ObservableList<Userinfo> list = FXCollections.observableList(collect);
        c1.setCellValueFactory(new PropertyValueFactory("account"));

        c2.setCellValueFactory(new PropertyValueFactory("idcard"));
        /*c3.setCellValueFactory(new PropertyValueFactory("school"));
        c4.setCellValueFactory(new PropertyValueFactory("coach"));
        c5.setCellValueFactory(new PropertyValueFactory("guardian"));
        c6.setCellValueFactory(new PropertyValueFactory("rela"));*/

        c7.setCellValueFactory(new PropertyValueFactory("contact"));
        tbv.setItems(list);
        tbv.setEditable(false);

    }

    public void Admsavebtn(){
      //  Userinfo userinfo = new Userinfo();

        Userinfo userinfo = new Userinfo();
        userinfo.setId(Long.parseLong(Admidfile.getText()));
        userinfo.setAccount(Admaccountfile.getText());
        userinfo.setPassword(Admpasswordfile.getText());

        int update = suidRich.update(userinfo);
        System.out.println(update);
        if(update == 1){
            new Alert(Alert.AlertType.ERROR, "保存成功！",
                    new ButtonType("确定", ButtonBar.ButtonData.YES)).show();
        }else{
            new Alert(Alert.AlertType.ERROR, "保存失败！",
                    new ButtonType("确定", ButtonBar.ButtonData.YES)).show();
        }
    }

    public void selected(){
        Admidfile.clear();
        Admaccountfile.clear();
        Admpasswordfile.clear();
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        List<Userinfo> select = suidRich.select(new Userinfo());
        Admidfile.setText(select.get(0).getId()+ "");
        Admaccountfile.setText(select.get(0).getAccount());
        Admpasswordfile.setText(select.get(0).getPassword());
    }
}
