package algorithm.boj;

import java.io.*;

public class boj11653소인수분해 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] array = new boolean[n+1];
        array[0] = array[1] = false;
        for(int i =0; i<=n; i++){
            array[i] = true;
        }

        for(int i=2; i*i <= n; i++){
            if(array[i]){
                for(int j =2; i*j <= n; j++){
                    array[i*j] = false;
                }
            }
        }

        int d = 2;
        while(n != 0){
            if(d > n){
                break;
            }
            if(array[d] && n%d == 0){
                sb.append(d+"\n");
                n /= d;
            } else {
                d++;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
