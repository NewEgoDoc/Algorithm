package algorithm.boj;

import java.io.*;

public class boj2606 {
	static int cnt = 0;

    static void dfs(int[][] adjacency, boolean[] visit, int vertex){
        if(visit[vertex] == true) return;

        visit[vertex] = true;
        cnt++;

        for(int i=0; i < adjacency.length; i++){
            if(adjacency[vertex][i]==1 && !visit[i]){
                dfs(adjacency,visit,i);
            }
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int adjacency[][] = new int[n+1][n+1];
        boolean visit[] = new boolean[n+1];

        for(int i =0; i<e; i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            adjacency[x][y] = 1;
            adjacency[y][x] = 1;
        }

        dfs(adjacency,visit,1);

        bw.append(cnt-1+"");
        bw.flush();

        bw.close();
        br.close();
    }
}
