package algorithm.boj.DynamicProgramming.Practice;

import java.io.*;

public class boj1932정수삼각형 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int[][] triangle = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < input.length; j++) {
                triangle[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = triangle[0][0];

        for (int i=1; i< triangle.length; i++) {

            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            for (int j=1; j<i+1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i -1][j - 1], dp[i -1][j]);
            }
        }

        int max = 0;
        for (int i=0; i<dp[dp.length - 1].length; i++) {
            max = Math.max(dp[dp.length - 1][i], max);
        }

        sb.append(max);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
