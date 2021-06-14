package Demo1.part2.utils;


import org.teasoft.bee.getData.SuidRichData;
import pojo.Userinfo;

import java.util.List;
import java.util.stream.Collectors;

public class InfoFilter {

    static final String role1 = "admin";
    static final String role2 = "referee";
    static final String role3 = "player";


    public static List<Userinfo> selectPlayer(){
        List<Userinfo> userinfos = SuidRichData.selectAll(new Userinfo());
        return userinfos.stream()
                .filter(userinfo -> userinfo.getRoles().equals(role3))
                .collect(Collectors.toList());
    }


}
