package algorithm.kakao;

import java.util.Queue;
import java.util.Stack;

public class Lv2괄호변환 {
    public static String solution(String p) {
        if(p.length() == 0){
            return "";
        }
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<p.length(); i++){
            char c = p.charAt(i);
            if(c == '(') stack.push('(');
            else ;
        }

        String answer = "";
        return answer;
    }
    public static void main(String[] args){
        ;
    }
}
