package algorithm.boj;

import java.io.*;

public class boj12919A와B2 {

    static int result = 0;

    public static void recur(String S,StringBuilder sb) {
        if(sb.toString().length() == S.length() || result == 1) {
            if(sb.toString().equals(S)) result=1;
            return;
        }


        if(sb.toString().charAt(0) == 'B'){
            sb.deleteCharAt(0);
            sb.reverse();
            recur(S,sb);
            sb.append('B');
            sb.reverse();
        }
        if(sb.toString().charAt(sb.toString().length()-1) == 'A'){
            sb.deleteCharAt(sb.toString().length()-1);
            recur(S,sb);
            sb.append('A');
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String S = br.readLine();
        String T = br.readLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        sb.append(T);
        recur(S,sb);

        answer.append(result);
        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
