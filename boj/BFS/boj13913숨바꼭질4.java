package algorithm.boj.BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj13913숨바꼭질4 {
    static int K;
    static int N;
    static int[] visit = new int[100001];
    static int[] previous = new int[100001];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(K == N) sb.append(0);
        else {System.out.println(bfs());}

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(previous[index]);
            index = previous[index];
        }

        // 최종 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = 0;

        while(!queue.isEmpty()){
            int X = queue.poll();
            for (int i = -1; i < 2; i++) {
                int next = i==0? X*2:X+i;

                if(K == X){
                    return (visit[X]);
                }

                if(next >= 0 && next < 100001){
                    if(visit[next] == 0){
                        queue.offer(next);
                        visit[next] = visit[X] + 1;
                        previous[next] = X;
                    }
                }
            }
        }
        return 0;
    }
}
