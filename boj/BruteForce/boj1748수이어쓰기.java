package algorithm.boj.BruteForce;

import java.io.*;

public class boj1748수이어쓰기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        long sum = 0;
        int num = 10;
        for(int i =1; i < N.length(); i++){
            sum += i*9*((int)Math.pow(10,i-1));
            sb.replace(0,sb.toString().length(),"");
        }

        sum += (Integer.parseInt(N) - (int)Math.pow(10,N.length()-1) + 1)*N.length();

        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
