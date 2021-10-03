package algorithm.boj.graphPractice;

import javax.lang.model.SourceVersion;
import java.io.*;
import java.util.*;

public class boj16947서울지하철2호선 {
    static ArrayList<Integer>[] list;
    static int n;
    static boolean[] isCycle;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //연결 개수 입력받고
        n = Integer.parseInt(br.readLine());

        //인접리스트형 그래프 만들기
        list = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        //나머지 입력값 까지 받아서
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        //------------------------------여기까지 입력값 모두 받았음


        //------------------------------알고리즘 적용
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j) +" ");
            }
            System.out.println();
        }

        isCycle = new boolean[n+1];
        for (int i = 1; i < n; i++) {// 모든 노드를 돌면서
            if(checkCycle(i,i,i)) break;//해당 노드에 사이클이 있는지 확인
            isCycle = new boolean[n+1];//사이클이 있는지 확인후에는 가비지 컬렉터를 사용하여 모든 사이클체크 초기화
        }


        int[] result = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if(!isCycle[i]) result[i] = bfs(i);
        }

        for(int i = 1; i <= n; i++) sb.append(result[i] + " ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int node) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(new Node(node, 0));
        visited[node] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();
            if(isCycle[current.v]) return current.count;

            for(int i = 0; i < list[current.v].size(); i++) {
                int next = list[current.v].get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(new Node(next, current.count + 1));
                }
            }
        }
        return 0;
    }

    public static boolean checkCycle(int prev, int node, int start) {//이전 현재 시작 인덱스를 받아서 시작

        isCycle[node] = true;//방문하자마자 해당 노드는 '방문했다'는 표시
        System.out.println("node = " + node);
        for(int i = 0; i < list[node].size(); i++) {//해당 노드의 인접노드를 모두 돌면서
            int next = list[node].get(i);//다음 노드 인덱스를 얻고
            if(!isCycle[next]) {//다음 인덱스가 아직 표시전이라면
                if(checkCycle(node, next, start)) return true;// 그 다음 노드도 재귀로 돌고
            } else if(next != prev && next == start)//이전 인덱스와 다음이 다르고 and 다음이 시작 노드의 인덱스와 같으면
                return true;
        }
        isCycle[node] = false; // 다 돌았으면 false로 다시 방문하지 않았다의 상태로 돌려준다.

        return false;
    }

    public static class Node {
        int v;
        int count;

        public Node(int v, int count) {
            this.v = v;
            this.count = count;
        }
    }
}
