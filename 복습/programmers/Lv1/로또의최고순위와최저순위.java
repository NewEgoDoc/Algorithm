package algorithm.복습.programmers.Lv1;

public class 로또의최고순위와최저순위 {
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
}
