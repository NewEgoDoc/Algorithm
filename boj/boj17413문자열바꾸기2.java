package algorithm.boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class boj17413문자열바꾸기2 {//
    public static void main(String[] args) throws IOException {

        StringBuilder newline = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for(int i =0; i < str.length(); i++){
           queue.add(str.charAt(i));
        }

        char c;
        boolean flag = true;
        while (!queue.isEmpty()){
            c = queue.poll();
            if(c == '<'){//문자의 맨처음에서 만났다면 그냥 < 출력하고 끝이지만
                         //문자 중간에서 만났다면 해당내용앞에 쌓여 있는 stack을 모두 출력한후 < 출력
                while(!stack.isEmpty()){
                    bw.write(stack.pop());
                }
                bw.write(c);
                flag = false;
            } else if(c == '>'){
                bw.write(c);
                flag = true;
            } else if(flag && c != ' '){//flag가 올라갔다는 것은 stack에 쌓아라
                stack.push(c);
            } else if(flag && c == ' '){
                while(!stack.isEmpty()){
                    bw.write(stack.pop());
                }
                bw.write(c);
            } else {
                bw.write(c);
            }
        }
        while(!stack.isEmpty()){//큐를 빠져나왔을 때 stack에 있는 값들을 모두 반환
            bw.write(stack.pop());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
