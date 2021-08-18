package algorithm.kakao.Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Lv2뉴스클러스팅 {
    public static int solution(String str1, String str2) {
        String newStr1 = str1.toLowerCase(Locale.ROOT);//.replaceAll("[^a-z]","");
        String newStr2 = str2.toLowerCase(Locale.ROOT);//.replaceAll("[^a-z]","");;


        //System.out.println(newStr1);
        //System.out.println(newStr2);
        int len1 = (newStr1.length()-1);
        int len2 = (newStr2.length()-1);
        System.out.println(len1);
        System.out.println(len2);
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();


        //중복허용
        for(int i = 0; i < len1; i++){
            String str = newStr1.substring(i, i+2).replaceAll("[^a-z]","");
            if(str.length() == 2){
                list1.add(str);
            }
            System.out.println(i+":"+str);
        }
        for(int i = 0; i <len2; i++){
            String str = newStr2.substring(i, i+2).replaceAll("[^a-z]","");
            if(str.length() == 2){
                list2.add(str);
            }
            System.out.println(i+":"+str);
        }


        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for(String s : list1) {
            if(list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        for(String s : list2) {
            union.add(s);
        }
        double a = intersection.size();
        double b = union.size();

        return (int)b == 0? 65536:(int)(a/b*65536);
    }
    public static void main(String[] args){
        String str1 = "handshake";
        String str2 = "shake hands";
        System.out.println(solution(str1,str2));
        /*
        str1	    str2	answer
        FRANCE	    french	16384
        handshake	shake hands	65536
        aa1+aa2	    AAAA12	43690
        E=M*C^2	    e=m*c^2	65536
        */
    }
}
