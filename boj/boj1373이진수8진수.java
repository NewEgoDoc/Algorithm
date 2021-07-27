package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1373이진수8진수 {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        String input = br.readLine();

        while(input.length()%3 != 0){
            input = "0"+input;
        }

        for(int i = 0; i < input.length()/3; i++){
            int octo = 0;
            String str = (input.substring(i*3,(i*3)+3));
            if(str.charAt(0) == '1') octo+=4;
            if(str.charAt(1) == '1') octo+=2;
            if(str.charAt(2) == '1') octo+=1;
            sb.append(octo);
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }

}
