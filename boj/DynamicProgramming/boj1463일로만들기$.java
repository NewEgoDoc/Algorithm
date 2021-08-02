package algorithm.boj.DynamicProgramming;

import java.io.*;

public class boj1463일로만들기$ {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        sb.append(recur(N));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int recur(int N) {
        if (dp[N] == null) {//우리는 배열에 해당 내용을 저장 하고 배열에 저장되어 있다면 넘어가게하는 dynamic programming 즉 모든 경우의 수를 한번만 돌고 추가 불필요한 반복을 없앨 것이다.

            if (N % 6 == 0) {// 6으로 나눠지는 경우 - 그 다음의 경우 3과 2로 나눠질 수 있고 해당 내용에서 당연히 -1에 대한 경우의 수도 체크해봐야한다.
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }
            else if (N % 3 == 0) {// 3으로만 나눠지는 경우 - 해당 경우 다음은 3으로 나눠지는 경우 그리고 -1을 해서 2로 나눠 지는 2가지 경우를 탐색한다.
                  dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            else if (N % 2 == 0) {// 2로만 나눠지는 경우 -  해당 경우 다음은 2로 나눠지는 경우와 -1을 해서 이후의 처리를 남겨놓는 경우가 남는다.
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 2와 3으로 나누어지지 않는 경우
            else {// 나눗셈이 불가능 하다면 -1을 더하여 그 다음 경우의 수를 탐색한다.
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
