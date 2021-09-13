package algorithm.boj.BruteForceNM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj15650NM2 {
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
        combination(1,0,N,M);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void combination(int start,int index, int N, int M){
        if(M == 0){
            for(int i = 1 ; i <= N; i++){
                if(visited[i]) sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= N; i++){
            visited[i] = true; //해당 위치를 방문 체크 해주고
            combination(i+1,index+1,N,M-1);//방문 위치 뒤로는 후보에서 제외된다 그리고 뽑을 개수도 한개 줄어들게됨
            visited[i] = false;
        }
    }
}
