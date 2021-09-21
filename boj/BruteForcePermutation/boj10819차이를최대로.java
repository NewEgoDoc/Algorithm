package algorithm.boj.BruteForcePermutation;

import java.io.*;

public class boj10819차이를최대로 {
    static int N;
    static boolean[] visited;
    static int[] inputArray;
    static int[] permutationArray;
    static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        visited = new boolean[N];
        inputArray = new int[N];
        for(int i =0; i < N; i++){
            inputArray[i] = Integer.parseInt(input[i]);
        }
        permutationArray = new int[N];
        permutation(0);

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void permutation(int index){
        if(index == N){
            setMax();
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                permutationArray[index] = inputArray[i];
                permutation(index + 1);
                visited[i] = false;
            }
        }
    }

    private static void setMax() {
        int sum = 0;
        for(int i = 0 ; i < N -1; i++){
            sum += Math.abs(permutationArray[i] - permutationArray[i+1]);
        }
        if(max < sum){
            max = sum;
        }
    }
}
