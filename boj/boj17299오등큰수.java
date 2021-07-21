package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj17299오등큰수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> answer = new Stack<>();

        int[] F = new int[1000010];
        for(int i =0 ; i < n; i++){
            int idx = Integer.parseInt(input[i]);
            F[idx]++;
        }

        for(int i= n-1; i >=0; i--){
            int num = Integer.parseInt(input[i]);
            while(!stack.isEmpty() && F[num] >= F[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()) answer.push(-1);
            else answer.push(stack.peek());

            stack.push(num);

        }

        for(int i = 0; i<n; i++){
            if(i == n-1) bw.write(answer.pop()+"\n");
            else bw.write(answer.pop()+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
