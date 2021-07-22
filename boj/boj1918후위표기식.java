package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj1918후위표기식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String exp = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i =0; i < exp.length(); i++) {
            if(exp.charAt(i) == '('){
                stack.push('(');
            } else if(exp.charAt(i) >= 'A' && exp.charAt(i) <= 'Z'){
                bw.write(exp.charAt(i));
            } else if(exp.charAt(i) == '+' || exp.charAt(i) == '-'){
                stack.push(exp.charAt(i));
            } else if(exp.charAt(i) == '*'|| exp.charAt(i) == '/') {

            } else if(exp.charAt(i) == ')'){
                while(!stack.isEmpty()){
                    if(stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    bw.write(stack.pop());
                }
            }
        }

        while(!stack.isEmpty()){
            bw.write(stack.pop());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
//(A+(B*C))-(D/E)
//A*(B+C)
