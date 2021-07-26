package algorithm.boj;

import java.io.*;

public class boj9093 {//단어뒤집기

    public static void main(String[] args) throws IOException {

        StringBuilder newline = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0;i<n;i++) {
            String cons = br.readLine();
            StringBuffer sb = new StringBuffer(cons);
            String[] strArr = sb.reverse().toString().split(" ");
            for(int j=strArr.length-1; j >= 0; j--){
                bw.write(strArr[j]);
                if(j != 0) bw.write(" ");
                else bw.write("\n");
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }

}
