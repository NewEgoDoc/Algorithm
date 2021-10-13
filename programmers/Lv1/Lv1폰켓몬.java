package algorithm.programmers.Lv1;

import java.util.HashSet;
import java.util.Set;

public class Lv1폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        // 중복 제거를 위한 set (순서 상관 없으므로 HashSet 사용)
        Set<Integer> set = new HashSet<>();
        // set에 모든 폰켓몬 번호를 add
        for (int num : nums) {
            set.add(num);
        }
        // set의 사이즈가 폰켓몬수/2 보다 크다면?
        // 폰켓몬수/2 만큼의 종류를 선택할 수 있다는 의미
        if (set.size() >= len/2) {
            answer = len/2;
            // set의 사이즈가 폰켓몬수/2 보다 작다면?
            // 폰켓몬수/2 만큼의 종류를 가질 수는 없고 set의 크기만큼의 종류를 가질 수 있음
        } else {
            answer = set.size();
        }
        return answer;
    }
}
