package algorithm.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DevMatching로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int zeroCnt = 0;

        Arrays.sort(lottos);
        for(int i = 0; i < 6; i++) {
            if(lottos[i] != 0) break;
            zeroCnt++;
        }

        Arrays.sort(win_nums);
        for(int j = 0; j < 6; j++) {
            for(int k = zeroCnt; k < 6; k++) {
                if(win_nums[j] != lottos[k])    continue;
                answer[0]++;
                answer[1]++;
            }
        }

        answer[0] += zeroCnt;

        for(int i = 0; i < 2; i++) {
            if(answer[i] == 6) answer[i] = 1;
            else if(answer[i] == 5) answer[i] = 2;
            else if(answer[i] == 4) answer[i] = 3;
            else if(answer[i] == 3) answer[i] = 4;
            else if(answer[i] == 2) answer[i] = 5;
            else answer[i] = 6;
        }

        return answer;
    }

    @Test
    public void test(){
        /*
[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
[0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]*/
        assertThat //solution({44, 1, 0, 0, 31, 25},{31, 10, 45, 1, 6, 19})
    }
}
