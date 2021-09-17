package algorithm.boj.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.*;

public class boj9095브루트포스123더하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int ans = solve(0, n);

            bw.write(String.valueOf(ans));
            bw.write("\n");
        }

        bw.flush();
        br.close();
    }

    // n을 만드는 경우의 수를 구하는 재귀 문제
    // sum은 현재 까지의 합의 상태를 나타냄!
    private static int solve(int sum, int n){

        // 불가능한 경우 0 반환
        if(sum > n) return 0;

        // 가능 시 1 반환
        if(sum == n) return 1;

        // 현재의 재귀 함수 상태에서 이후에 가능한 경우의 수를 모두 구한 뒤 반환!
        int curr = 0;
        for(int i=1; i <= 3; i++){
            curr += solve(sum+i, n);
        }
        return curr;
    }
}
