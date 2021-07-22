package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj10824네수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        sb.append(Long.parseLong(input[0]+input[1]) + Long.parseLong(input[2]+input[3]));

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
