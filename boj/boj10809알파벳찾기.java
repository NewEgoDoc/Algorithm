package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj10809알파벳찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int len = 'z' - 'a' +1;
        int[] intArr = new int[len];

        for(int i= 0; i < len; i++){
            intArr[i]--;
        }

        for(int i=0; i<str.length(); i++){
            int index = (str.charAt(i)-'a');
            intArr[index] = str.indexOf(index+'a');
        }

        for(int i = 0; i < len; i++){

            if(i == len-1) sb.append(intArr[i]);
            else sb.append(intArr[i]+" ");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
