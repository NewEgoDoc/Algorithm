package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj17298오큰수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] str = s.split(" ");
        int[] array = new int[n];

        for(int i =0; i<n; i++){
            array[i] = Integer.parseInt(str[i]);
        }



    }

}
