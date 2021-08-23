package algorithm.boj;

import java.io.*;

public class boj16916부분문자열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        String P = br.readLine();

        if(S.length() < P.length()){
            sb.append(0);
        } else {
            if (S.contains(P)) sb.append(1);
            else sb.append(0);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
