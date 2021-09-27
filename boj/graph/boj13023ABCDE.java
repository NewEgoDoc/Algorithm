package algorithm.boj.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj13023ABCDE {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        answer = 0;
        for (int i = 0; i < N; i++) {
            DFS(i,1);
            if(answer == 1){
                break;
            }
        }
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void DFS(int i, int depth) {
        if (depth == 5 || answer == 1) {
            answer = 1;
            return;
        }
        visited[i] = true;
        for (int j = 0; j < graph[i].size(); j++) {
            if (!visited[graph[i].get(j)]) {
                visited[graph[i].get(j)] = true;
                DFS(graph[i].get(j), depth + 1);
                visited[graph[i].get(j)] = false;
            }
        }
        visited[i] = false;
    }
}
