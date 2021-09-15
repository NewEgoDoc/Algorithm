package algorithm.boj.BruteForceNM;

import java.io.*;
import java.util.*;

public class boj15665NM11 {
    static StringBuilder answer = new StringBuilder();
    static int N;
    static int M;
    static int[] seq;
    static boolean[] visited;
    static int[] arr;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
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

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void permutation(int index){
        if(index == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                sb.append(arr[i] + " ");
            }

            if(!set.contains(sb.toString())){
                set.add(sb.toString());
                answer.append(sb.toString() + "\n");
            }
            return;
        }

        for(int i = 0; i < N; i++){
            visited[i] = true;
            arr[index] = seq[i];
            permutation(index + 1);
            visited[i] = false;
        }
    }
}
