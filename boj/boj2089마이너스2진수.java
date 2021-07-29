package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj2089마이너스2진수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        if(input == 0) sb.append(0);// 초기조건 무조건 챙기자!! 제발 쫌

        while(input != 0){
            int remainder = input%-2;
            input /= -2;
            if(remainder == -1) {
                stack.push(1);
                input++;
            } else {
                stack.push(remainder);
            }

        }

        while(!stack.isEmpty()){
           sb.append(stack.pop());
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
