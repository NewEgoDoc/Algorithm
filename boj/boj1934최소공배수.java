package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1934최소공배수 {
    public static int gcd(int u,int d){
        if(u%d == 0){
            return d;
        } else {
            return gcd(d,u%d);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int num;
            if(x>y) num = gcd(x,y);
            else num = gcd(y,x);

            sb.append(x*y/num+"\n");
        }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
    }
}
