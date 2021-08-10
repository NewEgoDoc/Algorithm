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
        for(int i = 1; i <= k; i++){
            for(int j = 0; j < n; j++) {
                if(i - coins[j] >= 0)
                    dp[i] += dp[i - coins[j]];// + coins[j]
            }
        }

        sb.append(dp[4]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
