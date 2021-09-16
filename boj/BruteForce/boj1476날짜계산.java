package algorithm.boj.BruteForce;

import java.io.*;

public class boj1476날짜계산 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);

        int e=1,s=1,m=1;
        int year = 1;
        while(true){
            if(e == E && s == S && m == M){
                sb.append(year);
                break;
            }

            year++;

            e++;
            s++;
            m++;

            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
