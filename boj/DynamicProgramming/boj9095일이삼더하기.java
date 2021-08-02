package algorithm.boj.DynamicProgramming;

import java.io.*;
import java.util.Arrays;

public class boj9095일이삼더하기 {
    static Integer[] dp;
    public static void recur(int N){
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 3]+ dp[i - 2]+dp[i - 1]);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[N];
        int[] tmp = new int[N];

        for(int i= 0; i< N; i++){
            answer[i] = Integer.parseInt(br.readLine());
            tmp[i] = answer[i];
        }

        Arrays.sort(tmp);
        dp = new Integer[tmp[N-1] + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        recur(tmp[N-1]);

        for(int i = 0; i< N; i++){
            sb.append(dp[answer[i]]+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

