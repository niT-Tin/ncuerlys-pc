package Demo1.part2.utils;



import pojo.Arrangement;

import java.util.ArrayList;
import java.util.List;

public class FormatUtils1 {
    public static List<String> formateAll(List<Arrangement> list) {

        List<String> formateList = new ArrayList<>();

        String Name = formateScheduleData(list);
        formateList.add(Name);
        String Gender = formateTimeData(list);
        formateList.add(Gender);

        return formateList;
    }

    public static String formateLine(Arrangement Arrangement) {
        return Arrangement.getSchedule() + "          " + Arrangement.getTime() + " " ;
    }

    private static  String formateScheduleData(List<Arrangement> list){

        StringBuffer buffer = new StringBuffer();

        for (Arrangement arr : list) {
            buffer.append(arr.getSchedule() + "\n");
        }
        return buffer.toString();
    }
    private static  String formateTimeData(List<Arrangement> list){

        StringBuffer buffer = new StringBuffer();

        for (Arrangement arr : list) {
            buffer.append(arr.getTime() + "\n");
        }
        return buffer.toString();
    }
}
