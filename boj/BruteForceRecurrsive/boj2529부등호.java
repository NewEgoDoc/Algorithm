package algorithm.boj.BruteForceRecurrsive;

import java.io.*;

public class boj2529부등호 {
    static int n;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static boolean stop1 = false;
    static boolean stop2 = false;
    static String[] st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*개수 입력받기*/
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        st = br.readLine().split(" ");
        visited = new boolean[10];
        topToBottom(0);
        bottomToTop(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void topToBottom(int index) {
        if(stop1) return;

        if(index == n+1){
            for (int i = 0; i < n; i++) {
                if(st[i].equals(">")){
                    if(arr[i] < arr[i + 1]) return;
                }
                if(st[i].equals("<")){
                    if(arr[i] > arr[i + 1]) return;
                }
            }

            for (int i = 0; i <= n; i++) {
                sb.append(arr[i]);
            }
            sb.append("\n");
            stop1 = true;
            return;
        }
        for(int i = 9; i >= 0; i--){
            if(!visited[i]){
                visited[i] = true;
                arr[index] = i;
                topToBottom(index+1);
                visited[i] = false;
            }
        }
    }

    private static void bottomToTop(int index) {
        if(stop2) return;

        if(index == n+1){
            for (int i = 0; i < n; i++) {
                if(st[i].equals(">")){
                    if(arr[i] <= arr[i + 1]) return;
                }
                if(st[i].equals("<")){
                    if(arr[i] >= arr[i + 1]) return;
                }
            }

            for (int i = 0; i <= n; i++) {
                sb.append(arr[i]);
            }
            sb.append("\n");
            stop2 = true;
            return;
        }
        for(int i = 0; i <= 9; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[index] = i;
                bottomToTop(index+1);
                visited[i] = false;
            }
        }
    }
}
