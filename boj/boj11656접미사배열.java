package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class boj11656접미사배열{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        Stack<Integer> stack = new Stack<>(); 
        Stack<Integer> answer = new Stack<Integer>();
        String string = br.readLine();
        
        int size = string.length();

        String[] str = new String[size];

        for(int i = 0; i < size; i++){
            str[i] = string.substring(i);
        }

        Arrays.sort(str);
        
        for(int i=0; i<size; i++) {
        	bw.write(str[i]+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
}