package algorithm.boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class boj10845 {//큐
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for(int i = 0;i<n;i++) {
            String command = br.readLine();
            
            if(command.contains("push")){
            	String[] cmd = command.split(" ");
                last = Integer.parseInt(cmd[1]);
                queue.add(last);
            } else if(command.contains("pop")){
                if(!queue.isEmpty()) bw.write(queue.poll()+"\n");
                else bw.write(-1+"\n");
            } else if(command.contains("size")){
                bw.write(queue.size()+"\n");
            } else if(command.contains("empty")){
                if(queue.isEmpty()) bw.write(1+"\n");
                else bw.write(0+"\n");
            } else if(command.contains("front")){
                if(!queue.isEmpty()) bw.write(queue.peek()+"\n");
                else bw.write(-1+"\n");
            } else if(command.contains("back")){
                if(!queue.isEmpty()) bw.write(last+"\n");
                else bw.write(-1+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
