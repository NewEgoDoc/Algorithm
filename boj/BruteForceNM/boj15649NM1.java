package algorithm.boj.BruteForceNM;

import java.io.*;

public class boj15649NM1 {
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        visited = new boolean[N+1];
        arr = new int[M];
        permutation(0,N,M);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void permutation(int index ,int N, int M){
        if(index == M){
            for(int i = 0 ; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(visited[i] == false){//방문 한적이 없다면
                visited[i] = true;//방문체크
                arr[index] = i;
                permutation(index+1,N,M);//인덱스만 하나로 앞으로 해주고 모두 방문해본다.
                visited[i] = false;//방문하고 나온후에는 해당 지점은 방문 취소 처리
            }
        }
    }
}
