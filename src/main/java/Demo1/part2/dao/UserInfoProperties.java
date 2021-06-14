package Demo1.part2.dao;

import org.teasoft.bee.getData.SuidRichData;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactory;
import pojo.Userinfo;

import java.util.List;

public class UserInfoProperties {

    SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
    public List<Userinfo> findAll(){
        return SuidRichData.selectAll(new Userinfo());
    }


    public int update(Userinfo report){
        return suidRich.update(report);
    }


    public Userinfo findOne(int id){
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        return suidRich.selectById(new Userinfo(), id);
    }


    public  int delete(int id){
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        return suidRich.deleteById(Userinfo.class, id);
    }


    public int insert(Userinfo userinfo){
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        return suidRich.insert(userinfo);
    }

}
