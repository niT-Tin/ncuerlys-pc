package util;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.teasoft.bee.getData.SuidRichData;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactory;
import pojo.User;
import pojo.Userinfo;


import java.util.List;

public class UserInfoUtils /*extends Application */{

    public static String formateLine(Userinfo userinfo){
        String tpl = "%-25s%-30s%-20s%-20s%-20s%-20s%-30s";
        return  String.format(tpl, userinfo.getIdcard(), userinfo.getAddress(),
                userinfo.getSchool(), userinfo.getCoach(), userinfo.getGuardian(),
                userinfo.getRela(), userinfo.getContact());
    }


//    public static void main(String[] args) {
//        List<Userinfo> userinfos = SuidRichData.selectAll(new Userinfo());
//        String tpl = "%-20s%-20s%-10s%-10s%-10s%-10s%-12s";
//        Label[] ls = new Label[5];
//
//        for (int i = 0; i < 5; i++) {
//            ls[i] = new Label();
//            ls[i].setFont(Font.font(14));
//            String format = String.format(tpl, userinfos.get(i).getIdcard(), userinfos.get(i).getAddress(),
//                    userinfos.get(i).getSchool(), userinfos.get(i).getCoach(), userinfos.get(i).getGuardian(),
//                    userinfos.get(i).getRela(), userinfos.get(i).getContact());
//            ls[i].setText(format);
//        }
//
//
//        for (Label l : ls) {
//            System.out.println(l.getText());
//        }
//    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//    }
}
