package algorithm.boj;

import java.io.*;
import java.util.*;

public class boj1874 {//스택수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter wr = new BufferedWriter((new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());

        boolean flag = false;
        Stack<Integer> stack = new Stack<Integer>();
        List<String> answer = new ArrayList<String>();
        stack.push(1);
        answer.add("+");
        int max = 1;

        for(int i=0; i < n; i++){
            int number = Integer.parseInt(br.readLine());
            if(stack.isEmpty() && max < number){
                for(int j = max+1; j<= number; j++){
                    stack.push(j);
                    answer.add("+");
                }
                max = stack.pop();
                answer.add("-");
                continue;
            }

            if(number > stack.peek()){
                for(int j = max+1; j <= number; j++){
                    stack.push(j);
                    answer.add("+");
                }
                max = stack.pop();
                answer.add("-");
            } else if(number == stack.peek()){
                stack.pop();
                answer.add("-");
            } else {
                wr.write("NO");
                flag = true;
                break;
            }
        }

        if(!flag && stack.isEmpty()){
            for(String a: answer){
                wr.write(a+"\n");
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }
}
