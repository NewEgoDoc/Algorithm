package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj17103골드바흐파티션 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int max = 1000000;// 최대값
        boolean[] array = new boolean[max+1];
        int[] tArray;
        array[0] = array[1] = false;// 필요없지만 일단
        for(int i =0; i<=max; i++){//모두 true로 정의하고
            array[i] = true;
        }

        for(int i=2; i*i <= max; i++){//루트값 까지만 살펴보면된다
            if(array[i]){//true를 만나고
                for(int j =2; i*j <= max; j++){//해당 배수들을 모두 false로
                    array[i*j] = false;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            count = 0;
            for(int j = 2; j <= N/2; j++){
                if(array[j] && array[N-j]){
                    count++;
                }
            }
            sb.append(count+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
