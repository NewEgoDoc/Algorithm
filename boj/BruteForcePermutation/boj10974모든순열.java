package algorithm.boj.BruteForcePermutation;

import java.io.*;

public class boj10974모든순열 {
    static boolean[] visited;
    static int[] permutationArray;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        permutationArray = new int[N];
        permutation(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void permutation(int index){
        if(index == N){
            for(int i = 0; i < N; i++){
                sb.append(permutationArray[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                permutationArray[index] = i;
                permutation(index + 1);
                visited[i] = false;
            }
        }

    }
}
