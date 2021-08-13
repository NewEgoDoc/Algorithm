package algorithm.kakao.Lv2;

import java.util.HashMap;
import java.util.Map;

public class Lv2방금그곡 {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxRunningTime = 0;

        m = m.replace("C#", "c")
                .replace("D#", "d")
                .replace("E#", "e")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");;

        for (String musicInfo : musicinfos) {
            String[] info = musicInfo.split(",");

            int hour = Integer.parseInt(info[1].split(":")[0]) - Integer.parseInt(info[0].split(":")[0]);
            int minute = Integer.parseInt(info[1].split(":")[1]) - Integer.parseInt(info[0].split(":")[1]);
            int runningTime = hour * 60 + minute;

            String cords = info[3].replace("C#", "c")
                    .replace("D#", "d")
                    .replace("E#", "e")
                    .replace("F#", "f")
                    .replace("G#", "g")
                    .replace("A#", "a");;
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < runningTime; i++) {
                stringBuilder.append(cords.charAt(i % cords.length()));
            }

            cords = stringBuilder.toString();

            if (cords.contains(m)) {
                if (maxRunningTime < cords.length()) {
                    maxRunningTime = cords.length();
                    answer = info[2];
                }
            }
        }

        if (answer.equals("")) {
            return "(None)";
        }

        return answer;
    }

    /*public static String solution(String m, String[] musicinfos) {
        String a =m;
        String answer ="";
        int maxTime = 0;
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

            String str = sb.toString();
            System.out.println(str);
            if(str.contains(a)){
                if(m.charAt(m.length()-1) == '#'){
                    if (maxTime < time) {
                        maxTime = time;
                        answer = factors[2];
                    }
                } else {
                    if(str.contains(m+"#")) continue;
                    else {
                        if (maxTime < time) {
                            maxTime = time;
                            answer = factors[2];
                        }
                    }
                }
            }
        }

        if(answer.equals("")) answer = "(None)";

        return answer;
    }*/
    public static void main(String[] args){
        String m = "ABC";
        String[] musicinfos ={"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m,musicinfos));
    }
}
