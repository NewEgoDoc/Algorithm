package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj9613GCD합 {
    public static int gcd(int up, int down){
        if(down == 0) return up;
        return gcd(down,up%down);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long sum = 0;//이거 long 타입이어야 함을 간과함 ㅠㅠ
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            sum = 0;
            int num = Integer.parseInt(input[0]);
            if (num > 1) {
                for (int j = 1; j < num; j++) {
                    for (int k = j + 1; k <= num; k++) {

                        int x = Integer.parseInt(input[j]);
                        int y = Integer.parseInt(input[k]);

                        if (x > y) sum += gcd(x, y);
                        else sum += gcd(y, x);
                    }
                }
                sb.append(sum + "\n");
            } else {
                sb.append(input[1] + "\n");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
