package algorithm.boj.BruteForce;

import java.io.*;

public class boj3085사탕게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        char[][] bomboni = new char[N][N];
        for(int i =0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                bomboni[i][j] = line.charAt(j);
            }
        }


        int max = 0;
        for(int i =0; i < N; i++){
            for(int j = 0; j < N-1; j++){
                swap(bomboni,i,j,i,j+1);

                int v = checkVertical(bomboni);
                int h = checkHorizontal(bomboni);
                if(max < v) max = v;
                if(max < h) max = h;

                swap(bomboni,i,j,i,j+1);
            }
        }

        for(int i =0; i < N-1; i++){
            for(int j = 0; j < N; j++){
                swap(bomboni,i,j,i+1,j);

                int v = checkVertical(bomboni);
                int h = checkHorizontal(bomboni);
                if(max < v) max = v;
                if(max < h) max = h;

                swap(bomboni,i,j,i+1,j);
            }
        }

        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void swap(char[][] bomboni, int i, int j,int i2,int j2){
        char tmp = bomboni[i][j];
        bomboni[i][j] = bomboni[i2][j2];
        bomboni[i2][j2] = tmp;
    }

    public static int checkVertical(char[][] bomboni){
        char c = 'a';
        int max = 0;
        int count = 0;
        for(int i = 0; i < bomboni.length; i++){
            count = 0;
            for(int j = 0; j < bomboni[i].length; j++){
               if((i == 0 && j == 0) || bomboni[i][j] != c) {
                   c = bomboni[i][j];
                   count = 1;
                   continue;
               }

               count++;
               if(max < count) max = count;
            }
        }
        return max;
    }
    public static int checkHorizontal(char[][] bomboni){
        char c = 'a';
        int max = 0;
        int count = 0;
        for(int i = 0; i < bomboni.length; i++){
            count = 0;
            for(int j = 0; j < bomboni[i].length; j++){
                if((i == 0 && j == 0) || bomboni[j][i] != c) {
                    c = bomboni[j][i];
                    count = 1;
                    continue;
                }

                count++;
                if(max < count) max = count;
            }
        }
        return max;
    }

    public static void print(char[][] bomboni){
        for(int i = 0; i < bomboni.length; i++) {
            for (int j = 0; j < bomboni[i].length; j++) {
                System.out.print(bomboni[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
