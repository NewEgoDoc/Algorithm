package algorithm.boj.DynamicProgramming;

import java.io.*;

public class boj11726이Xn타일링 {
    static Integer[] dp;
    //1 - 1
    //2 - 2
    //3 - 3
    //4 - 5
    //5 - 8
    public static int recur(int N){
        if(N == 0 || N == 1){
            return dp[N];
        } else {
            for (int i = 2; i <= N; i++) {
                dp[i] = (dp[i-1] + dp[i-2])%10007;
            }
            return (dp[N]%10007);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        sb.append(recur(N));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
