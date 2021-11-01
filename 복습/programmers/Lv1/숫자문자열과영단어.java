package algorithm복습.programmers.Lv1;

public class 숫자문자열과영단어 {
    public int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<nums.length; i++){
            s = s.replace(nums[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
