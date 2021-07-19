package algorithm.boj;

import java.io.*;
import java.util.*;

public class boj1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter wr = new BufferedWriter((new OutputStreamWriter(System.out)));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Character> answer = new LinkedList<>();

        for(int i=0; i < str.length(); i++){
            answer.add(str.charAt(i));
        }

        int cursor = str.length();

        for(int i=0; i < n; i++){
            String s = br.readLine();
            char cmd = s.charAt(0);
            if(cmd == 'L'){
                if(cursor != 0) cursor--;
            } else if(cmd == ('D')){
                if(cursor != answer.size()) cursor++;
            } else if(cmd == ('B')){
                if(cursor != 0) {
                	answer.remove(cursor-1);
                	cursor--;
                } 
            } else if(cmd == ('P')) {
      
                answer.add(cursor, s.charAt(2));
                cursor++;
            }
        }

        
        for(char st: answer) {
        	wr.write(st);
        }
        
        wr.flush();
        wr.close();
        br.close();
    }
}
