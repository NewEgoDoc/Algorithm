package algorithm.programmers.숫자문자열과영단어;

public class Solution {
    public static int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<nums.length; i++){
            s = s.replace(nums[i], String.valueOf(i));//replaceAll은 정규화인데 이후 차차해보자 ㅠㅠ
        }
        return Integer.parseInt(s);
    }

	public static void main(String[] args) {
		String s = "1zerotwozero3";
		System.out.println(solution(s));
	}
}
