package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj17087숨바꼭질6 {
    public static int gcd(int x,int y){
        if(y == 0) return x;
        return gcd(y,x%y);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        int[] sib= new int[Integer.parseInt(input[0])];

        for(int i = 0; i< Integer.parseInt(input[0]); i++){
            sib[i] = Math.abs(Integer.parseInt(input2[i])-S);
        }

        int g = sib[0];

        for(int i =1; i< sib.length; i++){
            g = gcd(g,sib[i]);
        }

        sb.append(g);


        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
