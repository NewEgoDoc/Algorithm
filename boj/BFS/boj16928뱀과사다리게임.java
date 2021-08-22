package algorithm.boj.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class boj16928뱀과사다리게임 {
    static boolean visited[] = new boolean[101];
    static int count[] = new int[101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] miro = new int[101];
        /*for(int i = 0 ; i <= 100; i++){
            miro[i] = i;
        }*/

        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);

        for(int i = 0; i < N+M; i++){
            String[] input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            int go = Integer.parseInt(input[1]);

            miro[index] = go;
        }

        bfs(miro);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int[] miro) {
        Queue<Integer> pq = new LinkedList<Integer>();
        pq.offer(1);
        count[1] = 0;
        visited[1] = true;

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            if(cur == 100) {
                System.out.println(count[cur]);
                return;
            }

            for(int i = 1; i < 7; i++) {
                int x = cur + i;
                if(100 < x) continue;
                if(visited[x]) continue;
                visited[x] = true;

                if(miro[x] != 0) { // 사다리 또는 뱀의 위치일때
                    if(!visited[miro[x]]) {
                        pq.offer(miro[x]);
                        visited[miro[x]] = true;
                        count[miro[x]] = count[cur] + 1;
                    }
                }else { //아무것도 아닐때
                    pq.offer(x);
                    count[x] = count[cur] + 1;
                }
            }
        }
    }
}
