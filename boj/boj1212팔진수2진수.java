package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj1212팔진수2진수 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for(int i = input.length()-1; i >= 0; i--){
            int num = input.charAt(i) -'0';
            int count = 3;
            while(count >0){
                stack.push(num%2);
                num /= 2;
                count--;
            }
        }

        while(!stack.isEmpty()){
            if(sb.toString().length() == 0 && stack.peek() == 0){
                stack.pop();
            }
            sb.append(stack.pop());
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }
}
