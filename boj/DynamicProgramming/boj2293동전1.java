package algorithm.boj.DynamicProgramming;

import java.io.*;

public class boj2293동전1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] dp = new int[k+1];
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;

        for(int i = 0; i < n; i++){
            for(int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];// + coins[i]
                System.out.println((j - coins[i]) + "+" + coins[i] +"= "+j +":" + dp[j]);

            }
            System.out.println();
        }

        sb.append(dp[k]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
