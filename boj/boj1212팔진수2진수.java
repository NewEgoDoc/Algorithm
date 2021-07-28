package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1212팔진수2진수 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] binaryOf = {"000","001","010","011","100","101","110","111"};
        String input = br.readLine();

        for(int i = 0; i < input.length(); i++){
            int num = input.charAt(i) -'0';
            if(i == 0){
                if(num == 1){
                    sb.append("1");
                } else if(num == 2){
                    sb.append("10");
                } else if(num == 3){
                    sb.append("11");
                } else {
                    sb.append(binaryOf[num]);
                }
            } else sb.append(binaryOf[num]);
        }

        if(sb.toString().equals("000")) bw.write("0");
        else bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    //String a1 = Integer.toBinaryString(temp);
}
