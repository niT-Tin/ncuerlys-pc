package Demo1.part2.utils;




import pojo.Userinfo;

import java.util.ArrayList;
import java.util.List;

public class FormatUtils {

    public static List<String> formateAll(List<Userinfo> list) {

        List<String> formateList = new ArrayList<>();

        String Name = formateNameData(list);
        formateList.add(Name);
        String Gender = formateGenderData(list);
        formateList.add(Gender);
        String Contact = formateContactData(list);
        formateList.add(Contact);
        String Idcard = formateIdcardData(list);
        formateList.add(Idcard);
        String Address = formateAddressData(list);
        formateList.add(Address);
        String School = formateSchoolData(list);
        formateList.add(School);
        String Coach = formateCoachData(list);
        formateList.add(Coach);
        String Guardian = formateGuardianData(list);
        formateList.add(Guardian);
        String Rela = formateRelaData(list);
        formateList.add(Rela);


        return formateList;
    }

    public static String formateLine(Userinfo userinfo) {

        final int maxLength = 12;
        String address = userinfo.getAddress();
        String idcard = userinfo.getIdcard();
        String contact = userinfo.getContact()+"";


        String format = "format";

        if(userinfo.getAddress().length() > maxLength)
            address = userinfo.getAddress().substring(0, maxLength - 1);
        if(userinfo.getIdcard().length() > maxLength){
            idcard = userinfo.getIdcard().substring(0, maxLength - 1);
            System.out.println(idcard);
        }

        if((userinfo.getContact()+"").length() > maxLength)
            contact = (userinfo.getContact()+"").substring(0, maxLength - 1);

        String tpl = "%-30s%-2s%-12s%-12s%-12s%-8s%-4s%-4s%-2s";
        return format; /*String.format(tpl, userinfo.getName(), (userinfo.getGender() ? "男" : "女"), contact, idcard,
                address, userinfo.getSchool(), userinfo.getCoach(), userinfo.getGuardian(), userinfo.getRela());*/


    }
    private static  String formateNameData(List<Userinfo> list){

        StringBuffer buffer = new StringBuffer();

        for (Userinfo info : list) {
            buffer.append(info.getName() + "\n");
        }
        return buffer.toString();
    }

    private static  String formateGenderData(List<Userinfo> list){

        StringBuffer buffer = new StringBuffer();

        for (Userinfo info : list) {
            String g;
            if(info.getGender())
                g = "男";
            else
                g = "女";
            buffer.append(g + "\n");
        }
        return buffer.toString();
    }

    private static  String formateContactData(List<Userinfo> list){

        StringBuffer buffer = new StringBuffer();

        for (Userinfo info : list) {
            buffer.append(info.getContact() + "\n");
        }
        return buffer.toString();
    }

    private static  String formateIdcardData(List<Userinfo> list){

        StringBuffer buffer = new StringBuffer();

        for (Userinfo info : list) {
            buffer.append(info.getIdcard() + "\n");
        }
        return buffer.toString();
    }

    private static  String formateAddressData(List<Userinfo> list){

        StringBuffer buffer = new StringBuffer();

        for (Userinfo info : list) {
            buffer.append(info.getAddress() + "\n");
        }
        return buffer.toString();
    }

    private static  String formateSchoolData(List<Userinfo> list){

        StringBuffer buffer = new StringBuffer();

        for (Userinfo info : list) {
            buffer.append(info.getSchool() + "\n");
        }
        return buffer.toString();
    }

    private static  String formateCoachData(List<Userinfo> list){

        StringBuffer buffer = new StringBuffer();

        for (Userinfo info : list) {
            buffer.append(info.getCoach() + "\n");
        }
        return buffer.toString();
    }

    private static  String formateGuardianData(List<Userinfo> list){

        StringBuffer buffer = new StringBuffer();

        for (Userinfo info : list) {
            buffer.append(info.getGuardian() + "\n");
        }
        return buffer.toString();
    }

    private static  String formateRelaData(List<Userinfo> list){

        StringBuffer buffer = new StringBuffer();

        for (Userinfo info : list) {
            buffer.append(info.getRela() + "\n");
        }
        return buffer.toString();
    }
}



