package algorithm.boj.BruteForceRecurrsive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj14889스타트와링크 {
    static int n;
    static int[][]abilities;
    static int[] start;
    static int[] link;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int min = 200000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*개수 입력받기*/
        n = Integer.parseInt(br.readLine());

        abilities = new int[n+1][n+1];
        visited = new boolean[n+1];
        start = new int[n/2];
        link = new int[n/2];

        /*개수만큼의 입력값 받기*/
        for (int i = 1; i <= n; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                abilities[i][j] = Integer.parseInt(input.nextToken());
            }
        }

        int start = 1;
        combination(n/2,start);

        sb.append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void combination(int r, int s) {
        if(r == 0){
            setStartLink();
            setMinValue();
        }

        for (int i = s; i <= n; i++) {
            visited[i] = true;
            combination(r-1,i+1);
            visited[i] = false;
        }
    }

    private static void setStartLink() {
        int index1 = 0;
        int index2 = 0;
        for (int i = 1; i <= n; i++) {
            if(visited[i]) {
                start[index1++] = i;
                System.out.print(i + " ");
                continue;
            }
            link[index2++] = i;
        }
        System.out.println();
    }


    private static void setMinValue() {
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                sum1 += abilities[start[i]][start[j]];
                sum2 += abilities[link[i]][link[j]];
            }
        }
        System.out.println("sum1 = " + sum1 +" sum2 = " + sum2);;
        int difference = (int)Math.abs(sum1 - sum2);
        if( min > difference ) min = difference;
    }
}
