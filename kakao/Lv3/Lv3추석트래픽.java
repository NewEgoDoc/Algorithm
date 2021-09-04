package algorithm.kakao.Lv3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Lv3추석트래픽 {
    public static int solution(String[] lines){
        int answer = 0;

        int[] cnt = new int[lines.length];
        double complete;

        for(int i = 0; i<lines.length;i++){
            lines[i] = lines[i].substring(11).replace(":","").replace("s","");

            int sec = Integer.parseInt(lines[i].substring(0,2))*3600 +
                    Integer.parseInt(lines[i].substring(2,4))*60+
                    Integer.parseInt(lines[i].substring(4,6));

            lines[i] = ""+ sec + lines[i].substring(6);
        }

        for(int i = 0; i< lines.length;i++){
            String[] split = lines[i].split("\\s");
            complete = Double.parseDouble(split[0]);

            double area = complete+1;

            for(int j = i;j< lines.length;j++){
                split = lines[j].split("\\s");

                double start = Double.parseDouble(split[0]) - Double.parseDouble(split[1]) + 0.001;
                if(start < area){
                    cnt[i]++;
                }
            }
        }
        for(int i = 0; i< cnt.length;i++){
            if(answer < cnt[i]) answer = cnt[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] lines={"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(solution(lines));
    }
}
