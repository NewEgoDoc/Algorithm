package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj11653소인수분해 {
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        sb.append(factorial(n));

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }
}
