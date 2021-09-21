package algorithm.boj.BruteForcePermutation;

import java.io.*;

public class boj10972다음순열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        if (next_number(array)) {
            for (int i = 0; i < n; i++) {
                sb.append(array[i] + " ");
            }
        } else {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    private static boolean next_number(int[] array) {
        //1. A[j-1] < A[i]를 만족하는 가장 큰 i를 찾는다.
        // 7 2 '3' 6 5 4 1
        int i = array.length -1;
        while(i > 0 && array[i-1]>=array[i]){
            i--;
        }
        System.out.println("i = " + i);
        if(i < 0) {
            return false;
        }

        //2. j >= i이면서 A[i-1] < A[j]를 만족하는 가장 큰 j를 찾는다.
        int j = array.length -1;
        while(array[i-1] >= array[j]){
            j--;
        }
        System.out.println("j = " + j);
        //3. A[j-1]과 A[j]를 swap 한다.

        swap(array,i-1, j);

        //4. A[j]부터 순열을 뒤집는다
        j= array.length -1;
        while (i < j){
            swap(array,i,j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}
