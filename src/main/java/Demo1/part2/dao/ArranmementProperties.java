package Demo1.part2.dao;

import org.teasoft.bee.getData.SuidRichData;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactory;
import pojo.Arrangement;

import java.util.List;

public class ArranmementProperties {

    SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
    public List<Arrangement> findAll(){
        return SuidRichData.selectAll(new Arrangement());
    }


    public int update(Arrangement report){
        return suidRich.update(report);
    }


    public Arrangement findOne(int id){
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        return suidRich.selectById(new Arrangement(), id);
    }


    public  int delete(int id){
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        return suidRich.deleteById(Arrangement.class, id);
    }


    public int insert(Arrangement Arrangement){
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        return suidRich.insert(Arrangement);
    }

}