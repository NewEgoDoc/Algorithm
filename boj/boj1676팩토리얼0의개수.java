package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1676팩토리얼0의개수 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int answer =0;

        while(n >= 5){
            answer += n / 5;
            n /= 5;
        }
        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }
}
