package algorithm.boj.DynamicProgramming;

import java.io.*;

public class boj15990일이삼더하기5 {//타일 붙이기 2293동전더하기,3933

    static int[][] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int max = 0;
        int[] ns = new int[T];
        for(int i = 0; i<T; i++){
            int num = Integer.parseInt(br.readLine());
            ns[i] = num;
            if(max < num){
                max = num;
            }
        }
        if(max < 4) max = 4;

        System.out.println(max);
        dp = new int[max+1][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i = 4; i < dp.length; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int i = 0; i < T; i++){
            System.out.print(ns[i]+": ");
            System.out.println(" "+dp[ns[i]][1] + " "+dp[ns[i]][2] +" "+dp [ns[i]][3] + "\n");
        }

        //sb.append();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
//코테는 재귀 그래프 이분탐색 벨만포드 다익스트라