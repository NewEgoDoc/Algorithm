package algorithm.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lv2멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = 0;
        for(int i = 0; i < w; i++)
            answer += (Long.valueOf(h) * i) / Long.valueOf(w);

        return answer * 2;
    }
    @Test
    public void test124() {
        Assertions.assertEquals(solution(8,12),80);
    }
}
