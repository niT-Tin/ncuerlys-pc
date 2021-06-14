package dao;

//package cn.edu.ncu.liu.example.dao;

import pojo.Report;
import org.teasoft.bee.getData.SuidRichData;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactory;

import java.util.List;

public class ReportProperties {

//    @Autowired
//    private SuidRich suidRich;

    /**
     * 查询所有信息
     * @return
     */
    public List<Report> findAll(){
//        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        return SuidRichData.selectAll(new Report());
    }

    /**
     * 修改信息
     * @param report
     * @return
     */
    public int update(Report report){
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
//        Condition
        return suidRich.update(report);
    }

    /**
     * 查询一个信息
     * @param id
     * @return
     */
    public Report findOne(int id){
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        return suidRich.selectById(new Report(), id);
//        SuidRich suidRich
    }

    /**
     * 删除信息
     * @param id
     * @return
     */
    public int delete(int id){
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        return suidRich.deleteById(Report.class, id);
    }

    /**
     * 增加信息
     * @param report
     * @return
     */
    public int insert(Report report){
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        return suidRich.insert(report);
    }

}
