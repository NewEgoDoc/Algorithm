package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class boj10866덱 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque=new LinkedList<>();

        for(int i=0; i<n; i++){
            String cmd = br.readLine();
            if(cmd.contains("push_front")){
                //push_front X: 정수 X를 덱의 앞에 넣는다.
                int num = Integer.parseInt(cmd.split(" ")[1]);
                deque.addFirst(num);
            } else if(cmd.contains("push_back")){
                //push_back X: 정수 X를 덱의 뒤에 넣는다.
                int num = Integer.parseInt(cmd.split(" ")[1]);
                deque.addLast(num);
            } else if(cmd.contains("pop_front")){
                //pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if(deque.isEmpty()) bw.write(-1+"\n");
                else bw.write(deque.pollFirst()+"\n");
            } else if(cmd.contains("pop_back")){
                //pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if(deque.isEmpty()) bw.write(-1+"\n");
                else bw.write(deque.pollLast()+"\n");
            } else if(cmd.contains("size")){
                //size: 덱에 들어있는 정수의 개수를 출력한다.
                bw.write(deque.size()+"\n");
            } else if(cmd.contains("empty")){
                //empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
                if(deque.isEmpty()) bw.write(1+"\n");
                else bw.write(0+"\n");
            } else if(cmd.contains("front")){
                //front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if(deque.isEmpty()) bw.write(-1+"\n");
                else bw.write(deque.getFirst()+"\n");
            } else if(cmd.contains("back")){
                //back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if(deque.isEmpty()) bw.write(-1+"\n");
                else bw.write(deque.getLast()+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
