package algorithm.boj.BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697숨바꼭질 {
    static int K;
    static int N;
    static int[] visit = new int[100001];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K == N) sb.append(0);
        else sb.append(bfs());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = 1;

        while(!queue.isEmpty()){
            int X = queue.poll();
            for (int i = -1; i < 2; i++) {
                int next = i==0? X*2:X+i;

                if(K == next){
                    return (visit[X]);
                }

                if(next >= 0 && next < 100001){
                    if(visit[next] == 0){
                        queue.offer(next);
                        visit[next] = visit[X] + 1;
                    }
                }
            }
        }
        return 0;
    }
}
