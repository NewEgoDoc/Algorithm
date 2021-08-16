package algorithm.boj.DynamicProgramming;

import java.io.*;

public class boj1699제곱수의합 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];

        //dp[1] = 1;

        for(int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                if(dp[i] > dp[i - (j * j)] + 1) { //
                    dp[i] = dp[i - (j * j)] + 1;
                }
            }
        }

        sb.append(dp[n]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
