package algorithm.boj;

import java.io.*;

public class boj13699점화식 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] t = new long[n+1];
        t[0] = 1;

        /*
        t(0)=1
        t(n)=t(0)*t(n-1)+t(1)*t(n-2)+...+t(n-1)*t(0)

        t(1)=t(0)*t(0)=1
        t(2)=t(0)*t(1)+t(1)*t(0)=2
        t(3)=t(0)*t(2)+t(1)*t(1)+t(2)*t(0)=5

       1 00                  1                            1
       2 01 10               1 + 1                        2       = t(1)*2
       3 02 11 20            1*2 + 1*1 + 2*1              5       = t(2)*t(0)*2 + t(1)*t(1)*1
       4 03 12 21 30         1*5 + 1*2 + 2*1 + 5*1        14      = t(3)*t(0)*2 + t(2)*t(1)*2
       5 04 13 22 31 40      1*14+ 1*5 + 2*2 + 5*1 + 14*1 42      = t(4)*t(0)*2 + t(3)*t(1)*2 + t(2)*t(2)*1
       6 05 14 23 32 41 50   1*42+ 1*14 + 2*5 + 5*2 + 14*1 + 42*1 = t(5)*t(0)*2 + t(4)*t(1)*2 + t(3)*t(2)*2
        */



        for(int i = 1; i < t.length; i++){
            t[i] = 0;
            for(int j = 0; j < i; j++){
                System.out.print("("+j+","+(i-j-1)+")");
                t[i] += t[j]*t[i-j-1];// +(j+","+(i-j-1));
            }
            System.out.println();
        }

        sb.append(t[n]);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
