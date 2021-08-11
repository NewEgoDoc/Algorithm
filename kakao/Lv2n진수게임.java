package algorithm.kakao;

import java.util.Stack;

public class Lv2n진수게임 {
    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < 50000; i++){
            int now = i;
            if(now < n) {
                if(now >= 10 && now <= 15) sb.append((char)('A'-10+now));
                else sb.append(now);
                continue;
            }
            while(now != 0){
                int remainder = now%n;
                if(remainder >= 0 && remainder < 10) stack.push((char)('0'+ remainder));
                else if(remainder >= 10 && remainder < 16) stack.push((char)('A'-10+ remainder));
                now/=n;
            }
            while(!stack.isEmpty()){
                char r = stack.pop();
                sb.append(r);

            }
        }
        String result = sb.toString();
        System.out.println(result);
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < t; i++){
            int index = p-1+m*i;
            System.out.print(index + " ");
            answer.append(result.charAt(index));
        }
        System.out.println();

        return answer.toString();
    }
    public static void main(String[] args){
        System.out.println(solution(16,16,2,2));//3648
    }
}
