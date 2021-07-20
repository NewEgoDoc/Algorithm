package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class boj1158요세푸스문제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();

        StringBuilder answer = new StringBuilder();

        answer.append("<");

        for(int i = 1; i <= N; i++){
            queue.add(i);
        }

        while(queue.size() != 1){
            for(int i=0; i<K-1; i++){
                int num = queue.poll();
                queue.offer(num);
            }
            answer.append(queue.poll()+", ");
        }

        answer.append(queue.poll());
        answer.append(">");

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
