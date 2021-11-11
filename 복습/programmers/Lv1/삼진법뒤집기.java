package algorithm.복습.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 삼진법뒤집기 {
    public int solution(int n) {
        String answer = "";

        while(n >= 3) {
            answer += n % 3;
            n /= 3;
        }
        answer += n;

        return Integer.parseInt(answer, 3);
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(45),7);
        Assertions.assertEquals(solution(125),229);
    }
}
