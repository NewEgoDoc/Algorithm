package Algorithm.kakao;

public class Lv1숫자문자열과영단어 {
    public static int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<nums.length; i++){
            s = s.replace(nums[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String s = "1zerotwozero3";
        System.out.println(solution(s));
    }
}
