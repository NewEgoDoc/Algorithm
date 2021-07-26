package algorithm.boj;


import java.io.*;

//소수에 해당하는 수의 배수를 모두 합성수로 처리하여 고려를 하지 않는 것
//예를 들어, 가장 처음 소수는 2이므로 4, 6, 8, ... 과 같은 2의 배수를 모두 합성수로 처리합니다.
//그 다음 소수는 3이므로 6, 9, 12, ... 와 같은 3의 배수를 모두 합성수로 처리하는 것
public class boj1929소수구하기 {
    public static void makePrimeList(int n,boolean[] array) {
        array[0] = false;
        array[1] = false;
        for(int i = 2; i*i <=n; i++) {
            if(array[i] == true){
                for(int j =2; i*j<=n; j++){
                    array[i*j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        boolean[] plist = new boolean[n+1];

        for(int i = 0; i <= n; i++){
            plist[i] = true;
        }

        makePrimeList(n,plist);
        for(int i=m; i <= n; i++){
            if(plist[i]) sb.append(i+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
