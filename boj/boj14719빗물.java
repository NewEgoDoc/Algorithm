package algorithm.boj;

import java.io.*;

public class boj14719빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = (br.readLine()).split(" ");
        String[] input2 = (br.readLine()).split(" ");
        int H = Integer.parseInt(input1[0]);
        int W = Integer.parseInt(input1[1]);

        int[][] block= new int[H][W];

        for(int i = 0; i < W; i++){
            int num = Integer.parseInt(input2[i]);
            //System.out.println(num);
            for(int j = H-1; j >= H-num; j--){//2
                block[j][i] = 1;
            }
        }
        int answer = 0;
        int cnt = 0;
        boolean btn = false;
        for(int i = 0; i < H; i++){
            btn = false;
            for(int j = 0; j < W; j++){
                if(block[i][j] == 1 && btn == false){
                    btn = true;
                    cnt = 0;
                } else if(block[i][j] == 0 && btn == true){
                    System.out.println(i + " " + j);
                    cnt++;
                } else if(block[i][j] == 1 && btn == true){
                    if(cnt > 0){
                        System.out.println(cnt);
                        answer += cnt;
                        cnt = 0;
                    }
                }
            }
        }

        for(int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(block[i][j]);
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
