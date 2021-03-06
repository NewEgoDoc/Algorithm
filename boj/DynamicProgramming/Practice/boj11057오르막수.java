package algorithm.boj.DynamicProgramming.Practice;

import java.io.*;

public class boj11057오르막수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        int answer = 0;
        for(int i=0; i <=9; i++){
            dp[1][i] = 1;
        }


        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = 0; k <= j; k++){
                    dp[i][j] += dp[i-1][k]%10007;
                }
            }
        }

        for(int i=0; i <=9; i++){
            answer += dp[N][i]%10007;
        }

        sb.append(answer%10007);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
