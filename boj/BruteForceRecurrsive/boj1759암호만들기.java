package algorithm.boj.BruteForceRecurrsive;

import java.io.*;
import java.util.*;

public class boj1759암호만들기 {
    static int n;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*첫째줄 입력값 정리*/
        StringTokenizer input1 = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(input1.nextToken());
        n = Integer.parseInt(input1.nextToken());

        /*둘째줄 입력값 정리*/
        StringTokenizer input2 = new StringTokenizer(br.readLine());
        char[] letters = new char[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            letters[i] = input2.nextToken().charAt(0);
        }

        Arrays.sort(letters);//문자들 오름차순으로 정리


        combination(letters,r,0);// nCr // n <-static변수

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void combination(char[] letters, int r, int start) {
        if(r == 0){
            if(checkLetters(letters)) printPassword(letters);
        }
        for(int i = start; i < n; i++){
            visited[i] = true;
            combination(letters,r-1,i+1);
            visited[i] = false;
        }
    }

    private static boolean checkLetters(char[] letters) {
        int consonant = 0;
        int vowel = 0;
        for (int i = 0; i < n; i++) {
            if(visited[i]) {
                if(letters[i] == 'a' || letters[i] == 'e' || letters[i] == 'i' || letters[i] == 'o' || letters[i] == 'u'){
                    vowel++;
                } else {
                    consonant++;
                }
            }
        }
        if(consonant >= 2 && vowel >= 1){
            return true;
        }
        return false;
    }

    private static void printPassword(char[] letters) {
        for (int i = 0; i < n; i++) {
            if(visited[i]) sb.append(letters[i]);
        }
        sb.append("\n");
    }

}
