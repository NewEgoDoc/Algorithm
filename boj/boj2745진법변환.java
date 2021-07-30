package algorithm.boj;

import java.io.*;

public class boj2745진법변환 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int B = Integer.parseInt(input[1]);

        double result = 0;
        for(int i = input[0].length()-1; i>=0; i--){
            char c = input[0].charAt(i);
            int s = 0;
            if(c >= '0' && c <= '9'){
                s = c-'0';
            } else if(c >= 'A' && c <= 'Z'){
                s = c-'A'+10;
            }
            result += Math.pow(B,input[0].length()-i-1)*s;
        }
        sb.append((long)result);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }
}
