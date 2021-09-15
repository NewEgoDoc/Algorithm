package algorithm.boj.BruteForceNM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class boj15664NM10 {
    static StringBuilder answer = new StringBuilder();
    static int N;
    static int M;
    static int[] seq;
    static boolean[] visited;
    static int[] arr;
    static HashSet<String> set = new HashSet<>();
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

        combination(0,0);

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void combination(int index, int start){
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
        for(int i = start; i < N; i++){
            visited[i] = true;
            arr[index] = seq[i];
            combination(index+1,i+1);
            visited[i] = false;
        }
    }
}
