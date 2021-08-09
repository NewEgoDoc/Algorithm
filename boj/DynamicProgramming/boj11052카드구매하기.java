package algorithm.boj.DynamicProgramming;

import java.io.*;

public class boj11052카드구매하기 {

    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] pack = new int[N+1];
        pack[0] = 0;
        for(int i = 1; i <= N; i++){
            pack[i] = Integer.parseInt(input[i-1]);
        }

        dp = new int[N+1];

        dp[0] = 0;
        dp[1] = pack[1];

        for(int i = 1; i <= N; i++){//2
            for(int j = 1; j <= i; j++){//2
                dp[i] = Math.max(dp[i],dp[i-j]+pack[j]);
            }
        }
        sb.append(dp[N]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
