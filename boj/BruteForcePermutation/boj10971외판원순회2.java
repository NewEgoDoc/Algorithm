package algorithm.boj.BruteForcePermutation;

import java.io.*;

public class boj10971외판원순회2 {
    static int N;
    static int[][] W;
    static int[] array;
    static boolean[] visited;
    static int min = 100000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(input[j]);
            }
        }

        array= new int[N];
        visited = new boolean[N];

        permutation(0);

        sb.append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void permutation(int index){
        if(index == N){
            setPath();
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                array[index] = i;
                permutation(index+1);
                visited[i] = false;
            }
        }
    }

    public static void setPath(){
        int sum = 0;

        for (int i = 0; i < N-1; i++) {
            int num = W[array[i]][array[i+1]];
            if(num == 0)
                return;
            sum += num;
        }
        if(W[array[N-1]][array[0]] == 0) return;
        sum += W[array[N-1]][array[0]];

        if(min > sum){
            min = sum;
        }
    }
}
