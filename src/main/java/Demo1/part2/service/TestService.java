package Demo1.part2.service;



import Demo1.part2.dao.UserInfoProperties;
import pojo.Userinfo;

import java.util.List;

public class TestService {

    public List<Userinfo> findAll(){
        UserInfoProperties userinfoProperties = new UserInfoProperties();
        return  userinfoProperties.findAll();
    }

}
