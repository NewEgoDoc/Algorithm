package algorithm.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Lv1폰켓몬 {
    public int solution(int[] nums) {
        int n = nums.length/2;

        Set<Integer> set = new HashSet<>();

        for (int num:nums) {
            set.add(num);
        }

        if(set.size() > n){
            return n;
        } else {
            return set.size();
        }
    }

    @Test
    public void 정답() {
        Assertions.assertEquals(2, solution(new int[]{3, 1, 2, 3}));
        Assertions.assertEquals(3, solution(new int[]{3,3,3,2,2,4}));
        Assertions.assertEquals(2, solution(new int[]{3,3,3,2,2,2}));
    }
}
