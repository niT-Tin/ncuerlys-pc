package Demo1.part2.panes;


import Demo1.part2.service.TestService;
import Demo1.part2.service.TestService1;
import Demo1.part2.utils.InfoFilter;
import cn.edu.scau.biubiusuisui.annotation.FXController;
import cn.edu.scau.biubiusuisui.annotation.FXRedirect;
import cn.edu.scau.biubiusuisui.annotation.FXWindow;
import cn.edu.scau.biubiusuisui.entity.FXBaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import org.teasoft.bee.getData.SuidRichData;
import pojo.Arrangement;
import pojo.Userinfo;
import util.InsertMulti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FXWindow(title = "裁判员"/*, mainStage = true*/, resizable = false, draggable = true/*, style = StageStyle.UTILITY*/)
@FXController(path = "fxml/referee.fxml")
public class Message extends FXBaseController {

    @FXML
    private TableView<Userinfo> tbv1;

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
    private TableColumn<Userinfo, String> c8;

    @FXML
    private TableColumn<Userinfo, String> c9;

    @FXML
    private TableView<Arrangement> tbv2;

    @FXML
    private TableColumn<Arrangement, String> c01;

    @FXML
    private TableColumn<Arrangement, String> c02;

    @FXML
    private Tab tb2;

    @FXML
    private Tab tb3;

    @FXML
    private TextField name1;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private TextField tf5;
    @FXML
    private TextField tf6;
    @FXML
    private ComboBox<String> cb;
    @FXRedirect
    public String to0(){
        this.closeStage();
        return "ControlLogin";
    }

    @Override
    public void onLoad() throws Exception {
    }

    @Override
    public void onShow() throws Exception {

        List<Userinfo> all = InfoFilter.selectPlayer();

        ObservableList<Userinfo> list = FXCollections.observableList(all);

        c1.setCellValueFactory(new PropertyValueFactory("name"));
        c2.setCellValueFactory(new PropertyValueFactory("gender"));
        c3.setCellValueFactory(new PropertyValueFactory("contact"));
        c4.setCellValueFactory(new PropertyValueFactory("idcard"));
        c5.setCellValueFactory(new PropertyValueFactory("address"));
        c6.setCellValueFactory(new PropertyValueFactory("school"));
        c7.setCellValueFactory(new PropertyValueFactory("coach"));
        c8.setCellValueFactory(new PropertyValueFactory("guardian"));
        c9.setCellValueFactory(new PropertyValueFactory("rela"));
        tbv1.setEditable(false);
        tbv1.setItems(list);
    }

    public void test(){
        List<Arrangement> arrangements = SuidRichData.selectAll(new Arrangement());

        ObservableList<Arrangement> list = FXCollections.observableList(arrangements);

        c01.setCellValueFactory(new PropertyValueFactory("schedule"));
        c02.setCellValueFactory(new PropertyValueFactory("time"));

        tbv2.setEditable(false);
        tbv2.setItems(list);
    }

    TestService userinfoService=new TestService();
    public List<Userinfo> selectAll(){
        return userinfoService.findAll();
    }

    public void onLoadarr() throws Exception {
    }

    public void onShowarr() throws Exception {

    }

    TestService1 ArrangementService=new TestService1();
    private ArrayList<String> multirace = new ArrayList<>();

    public List<Arrangement> selectarrAll(){
        return ArrangementService.findAll();
    }

    int sc = 2;

    public void grade(){
        multirace.clear();
        cb.getItems().clear();
        String[] s = { "双人赛", "三人赛", "五人赛", "全能赛", "精英赛"};

        multirace.addAll(Arrays.asList(s));
        ObservableList<String> multirace1 = FXCollections.observableArrayList(multirace);
        cb.getItems().addAll(multirace1);
    }
    public void getin(){
        String value = cb.getValue();
        switch(value){
            case "三人赛":
                sc = 3;
                break;
            case "五人赛":
                sc = 5;
                break;
            case "全能赛":
                sc = 6;
                break;
            case "精英赛":
                sc = 7;
                break;
            default:
                break;
        }
        boolean b = InsertMulti.insertMulti(name1.getText(), Long.parseLong(tf1.getText()), Long.parseLong(tf2.getText()), Long.parseLong(tf3.getText())
                , Long.parseLong(tf4.getText()), Long.parseLong(tf5.getText()), Long.parseLong(tf6.getText()), sc);
        if(b){
            new Alert(Alert.AlertType.CONFIRMATION, "录入成功", new ButtonType("确定", ButtonBar.ButtonData.YES)).show();
        }else
            new Alert(Alert.AlertType.CONFIRMATION, "录入失败", new ButtonType("确定", ButtonBar.ButtonData.YES)).show();
    }

}
