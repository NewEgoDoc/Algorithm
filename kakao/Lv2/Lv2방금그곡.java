package algorithm.kakao.Lv2;

import java.util.HashMap;
import java.util.Map;

public class Lv2방금그곡 {
    public static String solution(String m, String[] musicinfos) {
        String a =m;
        for(int i = 0; i < musicinfos.length; i++){
            String[] factors = musicinfos[i].split(",");
            StringBuilder sb = new StringBuilder();
            String[] time1 = factors[0].split(":");
            String[] time2 = factors[1].split(":");

            int time = (Integer.parseInt(time2[0]) - Integer.parseInt(time1[0]))*60 + (Integer.parseInt(time2[1])+Integer.parseInt(time1[1]));

            for(int j = 0; j < time; j++){
                //System.out.println(j+" : " +(j%(factors[3].length())));
                sb.append(factors[3].charAt(j%(factors[3].length())));
            }
            System.out.println(sb.toString());
            if(sb.toString().contains(a)){
                if(m.charAt(m.length()-1) == '#'){
                    return factors[2];
                } else {
                    if(sb.toString().contains(m+"#")) continue;
                    else return factors[2];
                }
            }
        }
        return "(None)";
    }
    public static void main(String[] args){
        String m = "ABC";
        String[] musicinfos ={"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m,musicinfos));
    }
}
