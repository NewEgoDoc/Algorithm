package algorithm.boj.DynamicProgramming;

import java.io.*;

public class boj2156포도주시식 {
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        int[] wines = new int[N+1];

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(br.readLine());
            wines[i] = num;
        }

        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];

        /*
        i == 0 첫번째 요소

        i==1  1

        i==2 1 2

        i==3   1 2 3(x)
               1   3        --- dp[1] + wines[3]
                 2 3        --- dp[0] + wines[2] + wines[3]
               1 2          --- dp[2]



        i==4    1 2 3  4

                1 2    4     -- dp[2] + wines[4]
                1   3  4     -- dp[1] + wines[3] + wines[4]
                  2 3
                1    3        -- dp[3]



        i==5 0 1 2 3 4 5
             0 1 2 3 4
             0 1 2 3   5
             0 1 2   4 5
             0 1   3 4 5
             0   2 3 4 5
               1 2 3 4 5
             0 1 2   4 5

             0 1 2     5
             0 1   3   5
             0   2 3   5     -- dp[3] + wines[5]
               1 2 3   5

        i==6 0 1 2 3 4 5 6
             0 1 2 3 4   6
             0 1 2 3   5 6
             0 1 2   4 5 6
             0 1   3 4   6
             0   2 3   5 6

        * */
        if(N >= 3) {
            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]));
                System.out.println(dp[i]);
            }
        }
        sb.append(dp[N]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
