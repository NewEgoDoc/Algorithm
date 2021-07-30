package algorithm.boj;

import java.io.*;
import java.util.Stack;

public class boj11005진법변환2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        Stack<Character> stack = new Stack<>();

        if(N == 0) stack.push('0');
        while(N != 0){
            int remainder = N % B;
            if(remainder >= 0 && remainder <=9){
                stack.push((char)(remainder+'0'));
            } else if(remainder >= 10 && remainder <= 35) {
                stack.push((char)(remainder-10+'A'));
            }
            N /= B;
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
