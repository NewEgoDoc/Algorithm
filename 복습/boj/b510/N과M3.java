package algorithm.복습.boj.b510;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N과M3 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        arr = new int[M];
        permutation(0,N,M);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void permutation(int index, int N, int M){
        if(index == M){
            for(int i = 0 ; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            arr[index] = i;
            permutation(index+1,N,M);
        }
    }
}
