package algorithm.boj.BruteForcePermutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj10973이전순열 {
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

        if (previous_number(array)) {
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

    static boolean previous_number(int[] a) {

        int i = a.length - 1;
        while (i > 0 && a[i] >= a[i - 1]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[i - 1] <= a[j]) {
            j--;
        }
        swap(a,i-1,j);

        j = a.length - 1;
        while (i < j) {

            swap(a,i,j);
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
