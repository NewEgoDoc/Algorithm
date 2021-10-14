package algorithm.programmers.Lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Lv2_124나라의숫자 {

    static int[] pNums = {4,1,2};

    static int[] dpNums ={7,1,2,6};

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int number = n;
        int remain;
        while(number != 0){
            remain = number%(pNums.length);
            number /= pNums.length;

            if(remain == 0) number--;

            sb.append(pNums[remain]);

        }

        return sb.reverse().toString();
    }

    public String solution2(int n) {
        StringBuilder sb = new StringBuilder();
        int number = n;
        int remain;
        while(number != 0){
            remain = number%(dpNums.length);
            number /= dpNums.length;

            if(remain == 0) number--;

            sb.append(dpNums[remain]);
        }

        return sb.reverse().toString();
    }

    @Test
    public void test124() {
        Assertions.assertEquals(solution(10),"41");
        Assertions.assertEquals(solution(1),"1");
        Assertions.assertEquals(solution(16),"121");
        Assertions.assertEquals(solution(30),"244");
        Assertions.assertEquals(solution(13),"111");
    }

    @Test
    public void test1267(){
        Assertions.assertEquals(solution2(1),"1");
        Assertions.assertEquals(solution2(2),"2");
        Assertions.assertEquals(solution2(3),"6");
        Assertions.assertEquals(solution2(4),"7");
        Assertions.assertEquals(solution2(5),"11");
        Assertions.assertEquals(solution2(40),"217");
    }

}
