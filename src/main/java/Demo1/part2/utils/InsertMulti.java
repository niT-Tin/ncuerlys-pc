package Demo1.part2.utils;

import org.teasoft.bee.erlys.gets.GetMyWish;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactory;
import pojo.Userinfo;

public class InsertMulti {

    public static boolean insertMulti(String name, Long[] scores, int sc){
       return insertMulti(name, scores[0], scores[1], scores[2],
                scores[3], scores[4], scores[5], sc);
    }

    public static boolean insertMulti(String name,Long fir,
                            Long sec, Long thr, Long fou, Long fif,
                            Long six, int sc){
        Long sum = fir + sec + thr +fou + fif + six;
        Userinfo userinfo = GetMyWish.selectByName(new Userinfo(), name);
        if(userinfo == null)
            return false;
        userinfo.setRacefir(fir);
        userinfo.setRacesec(sec);
        userinfo.setRacethr(thr);
        userinfo.setRacefou(fou);
        userinfo.setRacefif(fif);
        userinfo.setRacesix(six);
        userinfo.setRacescore(sum);
        switch(sc){
            case 2:
                userinfo.setSec(sum);
                break;
            case 3:
                userinfo.setThr(sum);
                break;
            case 5:
                userinfo.setFif(sum);
                break;
            case 6:
                userinfo.setWholes(sum);
                break;
            case 7:
                userinfo.setBests(sum);
                break;
        }
        SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
        int update = suidRich.update(userinfo);
        return update == 1;
    }

}
