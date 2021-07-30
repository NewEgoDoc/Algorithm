package algorithm.boj;

import java.io.*;

public class boj11729하노이탑 {
    public static int count = 0;
    public static void hanoi(int n, int start, int mid, int to ,StringBuilder sb){
        count++;
        if (n == 1) {//base case
            sb.append(start + " " + to + "\n");
            return;
        }
        hanoi(n - 1, start, to, mid,sb);// start에서 mid로 이동
        sb.append(start + " " + to + "\n");// start에서 to로 이동
        hanoi(n - 1, mid, start, to,sb);// mid에서 to로 이동
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        sb.append((int)(Math.pow(2, n) - 1)).append('\n');
        hanoi(n,1,2,3,sb);
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
