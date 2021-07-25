package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj10870피보나치수5 {
    public static int fibonacci(int n){
        if(n <= 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return fibonacci(n-2)+fibonacci(n-1);
    }

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        sb.append(fibonacci(n+1));

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }
}
