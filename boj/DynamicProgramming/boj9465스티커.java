package algorithm.boj.DynamicProgramming;

import java.io.*;
import java.util.Scanner;

public class boj9465스티커 {
    static int dp[][] , cost[][] ; // dp와 비용이 저장 될 배열

    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);

        int t= sc.nextInt(); // 테스트 케이스

        for(int i=0;i<t;i++) {
            int n= sc.nextInt();

            //입력되는 n값에 따라 배열을 선언
            cost = new int[2][n+1];
            dp = new int[2][n+1];


            for(int j=0;j<2;j++) { // 비용을 입력
                for(int k=1;k<=n;k++) {
                    cost[j][k] = sc.nextInt();
                }
            }

            // 0번째, 1번째 행의 첫 번째 열이 초기화로 초기값이 된다.
            dp[0][1] = cost[0][1];
            dp[1][1] = cost[1][1];


            for(int k=2;k<=n;k++) { // 열 반복만을 통해 0번과 1번행을 동시 처리
                dp[0][k] = Math.max( dp[1][k-1], dp[1][k-2])+cost[0][k];
                dp[1][k] = Math.max(dp[0][k-1],dp[0][k-2])+cost[1][k];
            }


            System.out.println(Math.max(dp[0][n], dp[1][n])); // n번 째 열의 최댓값을 반환 후 출력

        }

    }
}
