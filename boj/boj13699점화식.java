package algorithm.boj;

import java.io.*;

public class boj13699점화식 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
        t(0)=1
        t(n)=t(0)*t(n-1)+t(1)*t(n-2)+...+t(n-1)*t(0)

        t(1)=t(0)*t(0)=1
        t(2)=t(0)*t(1)+t(1)*t(0)=2
        t(3)=t(0)*t(2)+t(1)*t(1)+t(2)*t(0)=5

        00              1                            1
        01 10           1 + 1                        2  = t(1)*2
        02 11 20        1*2 + 1*1 + 2*1              5  = t(2)*2 + t(1)*1
        03 12 21 30     1*5 + 1*2 + 2*1 + 5*1        14 = t(3)*2 + t(2)*2
        04 13 22 31 40  1*14+ 1*5 + 2*2 + 5*1 + 14*1 42 = t(4)*2 + t(3)
        */



        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }
}
