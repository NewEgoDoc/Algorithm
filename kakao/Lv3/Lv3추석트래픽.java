package algorithm.kakao.Lv3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lv3추석트래픽 {
    public static int solution(String[] lines){
        int answer = 0;
        String[] starts = new String[lines.length];
        String[] ends = new String[lines.length];


        int i = 0;
        for(String line: lines){
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            StringBuilder sb = new StringBuilder();
            String[] info = line.split(" ");

            String date = info[0];
            String time = info[1];

            sb.append(date);
            sb.append(" ");
            sb.append(time);


            Date endDate = null;
            try {endDate = sdf1.parse(sb.toString());} catch (Exception e) {}


            String[] interval = info[2].split("(s|\\.)");
            int term = Integer.parseInt(interval[0])*1000;

            if(interval.length > 1){
                if(interval[1].length() == 3){
                    term += Integer.parseInt(interval[1]);
                } else if(interval[1].length() == 2){
                    term += Integer.parseInt(interval[1])*10;
                } else {
                    term += Integer.parseInt(interval[1])*100;
                }
            }

            starts[i] = sdf2.format(new Date(endDate.getTime() - term + 1));
            System.out.println(starts[i]);
            ends[i] = sdf2.format(new Date(endDate.getTime()));
            System.out.println(ends[i]);
            i++;
            System.out.println();
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
