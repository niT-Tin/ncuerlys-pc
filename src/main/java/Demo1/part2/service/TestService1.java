package Demo1.part2.service;


import Demo1.part2.dao.ArranmementProperties;
import pojo.Arrangement;

import java.util.List;

public class TestService1 {

    public List<Arrangement> findAll(){
        ArranmementProperties ArrangementProperties = new ArranmementProperties();
        return  ArrangementProperties.findAll();
    }

}
