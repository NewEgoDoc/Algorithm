package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1978소수찾기 {
    public static boolean isPrime(int n){
        if(n == 1) return false;

        for(int i = 2; i < n; i++) if(n % i == 0) return false;

        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        for(int i = 0; i<n; i++){
            int p = Integer.parseInt(str[i]);
            if(isPrime(p)) answer++;
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
