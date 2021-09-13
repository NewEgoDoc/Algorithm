package algorithm.boj.BruteForceNM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj15652NM4 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        arr = new int[M];
        combination(0,1,N,M);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void combination(int index, int start,int N,int M){
        if(0 == M){
            for(int i = 0 ; i < index; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++){
            if(index != 0 && arr[index - 1] > i) continue;
            arr[index] = i;
            combination(index+1,start,N,M-1);
        }
    }
}
