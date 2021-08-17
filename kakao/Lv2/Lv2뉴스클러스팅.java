package algorithm.kakao.Lv2;

import java.util.Locale;

public class Lv2뉴스클러스팅 {
    public static int solution(String str1, String str2) {
        int answer = 0;
        String newStr1 = str1.toLowerCase(Locale.ROOT).replaceAll("[^a-z]","");
        String newStr2 = str2.toLowerCase(Locale.ROOT).replaceAll("[^a-z]","");;

        System.out.println(newStr1);
        System.out.println(newStr2);
        int len1 = (newStr1.length()-1);
        int len2 = (newStr2.length()-1);
        System.out.println(len1);
        System.out.println(len2);
        String[] strArr1 = new String[len1];
        String[] strArr2 = new String[len2];

        //중복허용
        for(int i = 0; i < len1; i++){
            strArr1[i] = newStr1.substring(i, i+2);
            System.out.println(i+":"+strArr1[i]);
        }
        for(int i = 0; i <len2; i++){
            strArr2[i] = newStr2.substring(i, i+2);
            System.out.println(i+":"+strArr2[i]);
        }

        int union = 0;
        for(int i = 0; i <strArr1.length; i++){
            for(int j = 0; j < strArr2.length; j++){
                System.out.println(strArr1[i]+":"+strArr2[j]);
                if(strArr1[i].equals(strArr2[j])){
                    union++;

                }
            }
        }
        System.out.println(union);
        answer = (int)(65536*((float)union/(len1 + len2 - union)));

        return answer;
    }
    public static void main(String[] args){
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(solution(str1,str2));
        /*
        str1	    str2	answer
        FRANCE	    french	16384
        handshake	shake hands	65536
        aa1+aa2	    AAAA12	43690
        E=M*C^2	    e=m*c^2	65536
        */
    }
}
