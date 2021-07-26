package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2447별찍기10 {

    static char[][] matrix;

    public static void printStar(int index1, int index2,int n){
        if(n == 1) {
            matrix[index1][index2] = '*';
            return;
        }

        int nn = n/3;

        for(int i = 0; i < 3; i++){
            for(int j=0; j < 3; j++){
                if(i == 1 && j == 1){
                    continue;
                }
                printStar(index1 + i*nn,index2 + j*nn,n/3);
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        matrix = new char[n][n];
        for(int i = 0;i <n; i++){
            for(int j= 0; j < n; j++){
                matrix[i][j] = ' ';
            }
        }

        printStar(0,0,n);

        for(int i = 0; i < n; i++){
            for (int j= 0; j< n; j++){
                sb.append(matrix[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
