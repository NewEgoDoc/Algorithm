package algorithm.boj.BruteForceRecurrsive;

import java.io.*;
import java.util.*;

public class boj14501퇴사 {
    static int n;
    static int[] days;
    static int[] moneys;
    static boolean[] visited;
    static int max;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*개수 입력받기*/
        n = Integer.parseInt(br.readLine());

        days = new int[n+1];
        moneys = new int[n+1];
        visited = new boolean[n+1];
        max = 0;
        /*개수만큼의 입력값 받기*/
        for (int i = 1; i <= n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(input.nextToken());
            moneys[i] = Integer.parseInt(input.nextToken());
        }

        int totalDay = 0;
        combination(1);

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void combination(int index) {
        if(index > n+1){
            return;//값없이 리턴!
        }

        if(index <= n+1){//작거나 같을때 모두 탐색
            setMax();
        }

        for (int i = index; i <= n; i++) {
            visited[i] = true;
            combination(i+days[i]);
            visited[i] = false;
        }
    }

    private static void setMax() {
        int sum= 0;

        for (int i = 1; i <= n; i++) {
            if(visited[i]) sum += moneys[i];
        }
        if(sum > max){
            max = sum;
        }
    }
}
