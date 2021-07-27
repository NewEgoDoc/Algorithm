package algorithm.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj2004조합0의개수 {

    public static int countE(long num, int expo){
        int count = 0;
        while(num>= expo){
            count += num/expo;
            num /= expo;
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String[] str = (br.readLine().split(" "));

        long n = Long.parseLong(str[0]);
        long r = Long.parseLong(str[1]);

        int nTwo = countE(n,2);
        int nFive = countE(n, 5);

        int nrTwo = countE(n-r,2);
        int nrFive = countE(n-r, 5);

        int rTwo = countE(r,2);
        int rFive = countE(r, 5);

        int two = nTwo - (nrTwo+rTwo);
        int five = nFive - (nrFive+rFive);

        sb.append((two-five<0)? two:five);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
