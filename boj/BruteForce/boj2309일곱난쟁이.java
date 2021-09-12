package algorithm.boj.BruteForce;

import java.io.*;
import java.util.*;

public class boj2309일곱난쟁이 {
    static boolean[] visited = new boolean[9];
    static boolean isFound = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //

        int[] dwarfs = new int[9];
        for(int i = 0; i < 9; i++){
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(dwarfs);
        combination(dwarfs,0,9,7,100);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void combination(int[] dwarfs, int start, int n, int r,int target){
        if(r == 0 && !isFound){
            int sum = 0;
            boolean isSum = checkSum(sum,dwarfs,target);
            if(isSum) {
                isFound = true;
                printDwarfs(dwarfs);
            }
        }

        for(int i = start; i < n; i++){
            visited[i] = true;
            combination(dwarfs,i+1,n,r-1,target);
            visited[i] = false;
        }
    }

    public static boolean checkSum(int sum,int[] dwarfs,int target){
        for(int i = 0; i < 9; i++){
            if(visited[i]) sum += dwarfs[i];
        }

        if(sum == target){
            return true;
        }
        return false;
    }

    public static void printDwarfs(int[] dwarfs){
        for(int i=0; i < 9; i++){
            if(visited[i]) sb.append(dwarfs[i] + "\n");
        }
    }
}
