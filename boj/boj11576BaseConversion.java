package algorithm.boj;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class boj11576BaseConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);//미래진법
        int B = Integer.parseInt(input[1]);//현재진법

        int m = Integer.parseInt(br.readLine());

        String[] input2 = br.readLine().split(" ");

        Stack<String> stack = new Stack<>();
        long decimal;
        double mid = 0;
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(input2[i]);
            mid += Math.pow(A,m-i-1)*num;
        }

        decimal = (long)mid;

        while(decimal !=0){
            int remainder = (int)(decimal%B);
            //if(remainder >= 0 && remainder <= 9){
                stack.push(remainder+" ");
            //} else if(remainder >= 10 && remainder <= 30){
            //    stack.push((char)(remainder - 10 + 'A'));
            //}
            decimal /= B;
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());//.append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
17 8
2
2 16
 */
