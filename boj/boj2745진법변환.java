package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2745진법변환 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String[] str = (br.readLine()).split(" ");

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }
}
