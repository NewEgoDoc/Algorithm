package algorithm.복습.programmers.Lv1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 숫자문자열과영단어 {
    public int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<nums.length; i++){
            s = s.replace(nums[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }

    @Test
    public void test(){
        Assertions.assertEquals(solution("one4seveneight"),1478);
        Assertions.assertEquals(solution("23four5six7"),234567);
        Assertions.assertEquals(solution("2three45sixseven"),234567);
        Assertions.assertEquals(solution("123"),123);
    }

}
