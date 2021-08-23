package algorithm.boj;

import java.io.*;

public class boj16916부분문자열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        String P = br.readLine();

        sb.append(KMP(S,P));



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int KMP(String S,String P){
        int pi[] = getPi(P);
        int j = 0;
        for(int i =0; i < S.length(); i++){
            while(j>0 && S.charAt(i)!=P.charAt(j)){//S와 P가 같을 때까지
                j = pi[j-1];
            }
            if(S.charAt(i) == P.charAt(j)){
                if(j == P.length()-1){
                    return 1;
                } else {
                    j++;
                }
            }
        }
        return 0;
    }

    static int[] getPi(String P) {
        int[] pi = new int[P.length()];
        int j = 0;

        for(int i =1; i < P.length(); i++){
            while(j>0 && P.charAt(i)!=P.charAt(j)){
                j = pi[j-1];
            }
            if(P.charAt(i) == P.charAt(j)){
                j++;
                pi[i] = j;
            }
        }

        return pi;
    }
}
