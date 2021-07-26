package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj6588골드바흐의추측 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int max = 1000000;
        boolean[] array = new boolean[max+1];
        int[] tArray;
        array[0] = array[1] = false;
        for(int i =0; i<=max; i++){
            array[i] = true;
        }

        for(int i=2; i*i <= max; i++){
            if(array[i]){
                for(int j =2; i*j <= max; j++){
                    array[i*j] = false;
                }
            }
        }

        while(true){
            int num = Integer.parseInt(br.readLine());
            boolean flag = false;
            if(num == 0) break;

            for(int i = 2; i <= num/2; i++){
                if(array[i] && array[num -i]){
                    sb.append(num + " = " + i + " + " + (num-i)+"\n");
                    flag = true;
                    break;
                }
            }

            if(!flag) sb.append("Goldbach's conjecture is wrong.\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
