package algorithm.boj.DynamicProgramming.Challenge;

import java.io.*;

public class boj2225 {
    static int[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        dp = new int[N+1][K+1];

        for(int i = 1; i <= K; i++){
            dp[1][i] = i;
            System.out.println(dp[1][i]);
        }

        for(int i = 2; i <= N; i++){
            for(int j =1; j <=K; j++){
                for(int k = 1; k <= j; k++){
                    dp[i][j] += dp[i-1][k]%1000000000;
                }
                System.out.println(i + ":" + dp[i][j]);
            }
        }

        sb.append(dp[N][K]%1000000000);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
