package algorithm.복습.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int sum = 0;
        boolean []visited = new boolean[10];

        for(int number: numbers){
            visited[number] = true;
        }

        for(int i = 0; i < 10; i++){
            if(!visited[i]) sum += i;
        }

        return sum;
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}),14);
        Assertions.assertEquals(solution(new int[]{5, 8, 4, 0, 6, 7, 9}),6);
    }
}
