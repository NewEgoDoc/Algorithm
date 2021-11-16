package algorithm.복습.boj.b510;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class N과M5 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int N;
    static int M;
    static int[] seq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        String[] input2 = br.readLine().split(" ");
        seq = new int[N];


        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(seq);
        arr = new int[M];
        permutation(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void permutation(int index){
        if(index == M){
            for(int i = 0 ; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]) {
                visited[i] = true;
                arr[index] = seq[i];
                permutation(index+1);
                visited[i] = false;
            }
        }
    }
}
