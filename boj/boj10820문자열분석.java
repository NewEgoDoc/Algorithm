package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj10820문자열분석 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while ((str = br.readLine()) != null) {
            int lowerCase = 0;
            int upperCase = 0;
            int num = 0;
            int space = 0;

            for(int i =0; i< str.length(); i++){
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                    lowerCase++;
                } else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    upperCase++;
                } else if(str.charAt(i) == ' '){
                    space++;
                } else if((str.charAt(i) >= '1' && str.charAt(i) <= '9')||str.charAt(i) == '0'){
                    num++;
                }
            }
            bw.write(lowerCase + " ");
            bw.write(upperCase + " ");
            bw.write(num + " ");
            bw.write(space + "\n");
            bw.flush();

        }

        bw.flush();
        bw.close();
        br.close();
    }
}