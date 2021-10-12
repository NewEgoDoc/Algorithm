package algorithm.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DevMatching로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = {6,6};
        int same = 0;
        int numberofZero= 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    same++;
                }
            }
        }

        for (int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) numberofZero++;
        }

        if(same+numberofZero > 1) {
            answer[0] -= (same+numberofZero-1);
        }

        if(same > 1) {
            answer[1] -= (same-1);
        }
        return answer;
    }
    @Test
    public void test(){
         Assertions.assertArrayEquals(solution(new int[]{44, 1, 0, 0, 31, 25},new int[]{31,10,45,1,6,19}),new int[]{3,5});
         Assertions.assertArrayEquals(solution(new int[]{0, 0, 0, 0, 0, 0},new int[]{38, 19, 20, 40, 15, 25}),new int[]{1,6});
         Assertions.assertArrayEquals(solution(new int[]{45, 4, 35, 20, 3, 9},new int[]{20, 9, 3, 45, 4, 35}),new int[]{1,1});
    }
}
