package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1212팔진수2진수 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();


        for(int i = 0; i < input.length(); i++){
            int num = input.charAt(i) -'0';

        }


        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }
}
