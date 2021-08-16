package algorithm.boj.DynamicProgramming;

import java.io.*;

public class boj2193이친수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[91][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i= 2; i <= n; i++){
            for(int j = 0; j <2; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][0] + dp[i-1][1];
                } else {
                    dp[i][j] = dp[i-1][0];
                }
            }
        }

        sb.append((dp[n][0] + dp[n][1]));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
