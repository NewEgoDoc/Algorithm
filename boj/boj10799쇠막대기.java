package algorithm.boj;

import java.io.*;
import java.util.Stack;

public class boj10799쇠막대기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int answer = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '('){
                stack.push('(');
        } else if(input.charAt(i) == ')'){
                stack.pop();
                if(input.charAt(i-1) == '('){
                    answer += stack.size();
                } else if(input.charAt(i-1) == ')'){
                    answer++;
                }
            }
        }
        bw.write(answer+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
