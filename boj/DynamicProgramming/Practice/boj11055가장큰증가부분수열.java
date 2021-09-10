package algorithm.boj.DynamicProgramming.Practice;

import java.io.*;

public class boj11055가장큰증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[N];

        dp[0] = array[0];

        for(int i=1;i< N;i++) {
            dp[i] = array[i];
            for(int j=0;j<i;j++) {
                if(array[i]>array[j]) {
                    dp[i] = Math.max(dp[j]+array[i],dp[i]);
                }
            }
        }

        int max = 0;
        for(int i=0;i< N;i++) {
            if(dp[i]>max) {
                max = dp[i];
            }
        }
        sb.append(max);
        //https://fbtmdwhd33.tistory.com/77
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
