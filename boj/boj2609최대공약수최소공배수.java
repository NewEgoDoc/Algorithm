package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2609최대공약수최소공배수 {
    public static int gcd(int u, int d){
        int r = u%d;

        if(r == 0){
            return d;
        } else {
            return gcd(d,r);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split(" ");

        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int answer = 0;

        if(A > B){
            answer = gcd(A,B);
        } else {
            answer = gcd(B,A);
        }

        sb.append(answer+"\n");
        sb.append(A*B/answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
