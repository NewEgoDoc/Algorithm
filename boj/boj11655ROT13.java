package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj11655ROT13 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i < input.length(); i++){
            int num = input.charAt(i);

            if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
                sb.append();
            } else if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                sb.append();
            } else {
                sb.append(input.charAt(i));
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
