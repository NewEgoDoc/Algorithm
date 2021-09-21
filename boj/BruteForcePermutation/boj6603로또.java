package algorithm.boj.BruteForcePermutation;

import java.io.*;

public class boj6603로또 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = null;
        while(true){
            input = br.readLine();//입력갑 받기

            if(input.equals("0")){
                break;
            }

            String[] inputArr = input.split(" ");//입력값 공백으로 나눠 배열로 치환
            int n = Integer.parseInt(inputArr[0]);// 배열의 크기
            int[] arr = new int[n];//배열 만들기
            boolean[] visited = new boolean[n];//이후 조합을 체크하기위한 체크값
            for(int i = 1; i <= n; i++){//배열에 각 입력값 삽입
                arr[i-1] = Integer.parseInt(inputArr[i]);
            }
            //Arrays.sort(arr);//이미 입력값부터 오름차순으로 있기 때문에 필요없음
            combination(arr,visited,n,6,0);// nCr (r==6) 시작
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void combination(int[] arr, boolean[] visited, int n, int r,int start) {
        if(r == 0){
            print(arr,visited,n);
        }
        for(int i = start; i < n; i++){
            visited[i] = true;
            combination(arr,visited,n,r-1,i+1);
            visited[i] = false;
        }
    }

    public static void print(int[] arr, boolean[] visited, int n){
        for(int i = 0; i < n; i++){
            if(visited[i]) sb.append(arr[i]+" ");
        }
        sb.append("\n");
    }
}
