package algorithm.boj.BFS;

import java.io.*;
import java.util.*;

public class boj16928뱀과사다리게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] miro = new int[101];
        boolean[] visited = new boolean[101];
        int[] count = new int[101];
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);

        for(int i = 0; i < N+M; i++){
            String[] input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            int go = Integer.parseInt(input[1]);

            miro[index] = go;
        }

        bfs(miro,visited,count,sb);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int[] miro,boolean[] visited,int[] count,StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        count[1] = 0;
        visited[1] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now == 100) {
                sb.append(count[now]);
                return;
            }

            for(int i = 1; i < 7; i++) {
                int x = now + i;
                if(100 < x) continue;
                if(visited[x]) continue;
                visited[x] = true;

                if(miro[x] == 0) {
                    queue.offer(x);
                    count[x] = count[now] + 1;
                }else if(!visited[miro[x]]) {
                    queue.offer(miro[x]);
                    visited[miro[x]] = true;
                    count[miro[x]] = count[now] + 1;
                }
            }
        }
    }
}
