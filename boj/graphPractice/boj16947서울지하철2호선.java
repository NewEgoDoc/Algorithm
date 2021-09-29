package algorithm.boj.graphPractice;

import java.io.*;
import java.util.*;

public class boj16947서울지하철2호선 {
    static int n;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean[] cycle;
    static int[] ans;

    /*
    4
    1 3
    4 3
    4 2
    1 2

    이 문제는 그래프의 탐색을 이용하여 순환(Cycle)이 발생하는 지를 인지하고 해당 순환(Cycle)이 발생하는 지점을 모두 찾은 후,
    다른 정점들에서 해당 Cycle로의 거리를 구하는 문제이다.
    기본적으로 지하철 역사간의 연결은 양방향으로 연결되기 때문에 사실상 무방향 그래프로 구현이 된다.
    무방향 그래프의 경우에 순환(Cycle)을 찾은 뒤 거리를 계산하면 된다.

    무방향 그래프에서 순환(Cycle)을 찾는 것은 BFS, DFS의 두 가지 방법 모두 가능하지만 여기서는 순환(Cycle) 탐지는 DFS로 구현하였고 거리 계산은 BFS로 구현하였다.

    DFS를 이용해 무방향 그래프의 순환(Cycle) 탐지를 하는 방법은 상단의 DFS 관련 포스팅 글을 참고하자.  기본적으로 방법은 아래와 같다.

    ⑴ 그래프를 만들고 재귀 형태로 탐색하는 함수를 생성하여 현재 정점, 방문 여부 배열, 재귀, parent 배열을 전달한다.
      - parent는 현재 노드와 이어진 이전에 탐색된 노드가 저장된 배열
    ⑵ 현재 탐색 정점을 방문 완료로 표시하고 parent를 이전 정점으로 저장
    ⑶ 현재 정점에 이어진 인접 정점을 모두 차례로 탐색 수행한다.
    ⑷ 인접 정점이 아직 미방문 상태라면 재귀 호출을 하여 그 결과를 받아 반환
    ⑸ 인접 정점이 기 방문 상태이며 parent가 현재 정점 값이 아니라면 순환 있음으로 결과값 반환

    위 ⑸를 좀 설명하자면, 아래와 같다.

    인접 정점의 parent가 현재 정점인 경우, 현재를 A, 인접을 B정점이라고 할 때,
    A방문 후, B에서 다시 A를 방문했다는 의미이므로,
     무방향 그래프에서 상호 인접 정점끼리는 무조건 재 탐색 수행을 하고자 하기 때문에 이를 제외 해야 한다.

    인접 정점의 parent가 현재 정점이 아니라면
    A -> B -> A의 순이 아니라 A -> B -> ? -> ? -> A 와 같이 중간에 다른 정점들을 추가로 탐색했다는 의미이며,
    이는 당연히 Cycle이 있는 것이다.

    * */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        cycle = new boolean[n+1];
        visited = new boolean[n+1];
        ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i]=new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        for(int i=1; i <= n; i++){
            // Cycle이 있다면 추가 반복문 확인을 멈춘다.
            if(isCycle(i, -1, i)){
                break;

                // 현재 위치에서 탐색 시 발견 못했다면 다음 탐색 위치에서 시작하도록 하기 위해
                // 방문 배열을 초기화 한다.
            } else {
                visited = new boolean[n+1];
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= n; i++){
            sb.append(ans[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isCycle(int u, int parent, int start) {
        visited[u] = true;
        for(int v : graph[u]){

            // 현재 정점의 인접 정점의 parent는 현재 정점으로 지정하여 전달함.
            if(!visited[v]){
                if(isCycle(v, u, start)){
                    cycle[v] = true;
                    return true;
                }

                // 재귀를 통해 탐색 시, 다음 인접 정점이 현재 정점의 parent가 아니라면
                // 중간이 다른 경로를 통해 방문된 뒤 도착한 것이라서 Cycle이 있는 것

                // 최초 시작 위치로 돌아온 경우에 해당 정점들만 Cycle로 처리할 수 있도록 해야 하므로
                // v==start를 추가해야 한다.
            } else if(v != parent && v == start){
                cycle[v] = true;
                return true;
            }
        }
        return false;
    }
    // BFS를 활용하여 Cycle과 각 정점 사이의 거리를 계산하는 코드
    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n+1];
        for(int i=1; i <= n; i++){
            if(cycle[i]) {
                visited[i] = true;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : graph[u]){
                if(!visited[v]){
                    q.offer(v);
                    visited[v] = true;
                    ans[v] = ans[u]+1;
                }
            }
        }
    }
}
