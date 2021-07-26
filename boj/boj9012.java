package algorithm.boj;

import java.io.*;
import java.util.Stack;

public class boj9012 {//괄호
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter wr = new BufferedWriter((new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());

        boolean flag = false;

        for(int i=0; i < n; i++){
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();
            flag = false;
            for(int j = 0; j < line.length(); j++){
                if(stack.isEmpty() && line.charAt(j) == ')') {
                    wr.write("NO\n");
                    flag = true;
                    break;
                }
                if(line.charAt(j) == '(') stack.push('(');
                else if (line.charAt(j) == ')') stack.pop();
            }
            if(stack.isEmpty() && !flag){
                wr.write("YES\n");
            } else if(!stack.isEmpty() && !flag){
                wr.write("NO\n");
            }
        }
        wr.flush();
        wr.close();
        br.close();
    }
}
