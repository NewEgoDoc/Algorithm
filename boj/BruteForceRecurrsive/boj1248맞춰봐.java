package algorithm.boj.BruteForceRecurrsive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1248맞춰봐 {
    static int n;
    static char[][] seq;
    static boolean[] visited;
    static int[] arr;
    static boolean isDone = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*개수 입력받기*/
        n = Integer.parseInt(br.readLine());

        seq = new char[n+1][n+1];
        visited = new boolean[21];
        arr = new int[n];
        int index = 0;
        String letters = br.readLine();
        /*개수만큼의 입력값 받기*/
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                seq[i][j] = letters.charAt(index++);
            }
        }

        permutation(0);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + " ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean permutation(int index) {
        if (index == n) {
            return true;
        }
        for (int i = 0; i <= 20; i++) {
            arr[index] = i - 10;
            if (check(index) && permutation(index + 1))
                return true;
        }
        return false;
    }

    private static boolean check(int index) {
        int sum = 0;
        for(int i = index; i >= 0; i--) {
            sum += arr[i];
            if(seq[i][index] == '0' && sum != 0)
                return false;
            if(seq[i][index] == '-' && sum >= 0)
                return false;
            if(seq[i][index] == '+' && sum <= 0)
                return false;
        }
        return true;
    }
}

//https://tttuer.tistory.com/196 참고한 블로그