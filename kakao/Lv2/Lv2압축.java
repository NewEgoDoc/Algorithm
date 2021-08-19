package algorithm.kakao.Lv2;

import java.util.ArrayList;
import java.util.List;

public class Lv2압축 {
    public static int[] solution(String msg) {
        //int[] answer = {};
        List<String> dict = new ArrayList<>();
        dict.add("");
        for(int i = 0; i < 26; i++){
            dict.add(String.valueOf((char)('A'+i)));
        }
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < msg.length();i++){
            System.out.println(i+":"+dict);
            int x = 1;
            boolean flag = false;
            int index = 1;
            while(i+x<msg.length()){

                String str = msg.substring(i,i+x);
                System.out.println(str);
                int count = 0;
                for(int j = 1; j < dict.size(); j++){
                    if(str.equals(dict.get(j))){
                        index = j;
                        j++;

                        flag = false;
                        break;
                    }
                    count++;
                }
                if(count == dict.size()-1){
                    dict.add(str);
                    break;
                }
                x++;
            }
            //i += x-1;
            answer.add(index);
        }

        int[] a= new int[answer.size()];
        for(int i =0 ; i<a.length; i++){
            a[i] = answer.get(i);
        }
        return a;
    }
    public static void main(String[] args){
        String msg = "KAKAO";
        int[] array = solution(msg);

        for(int i = 0; i < array.length; i++){
        System.out.println(array[i]);

        }
        /*
        	"KAKAO"
기댓값 〉	[11, 1, 27, 15]
실행 결과 〉	실행한 결괏값 []이(가) 기댓값 [11,1,27,15]와(과) 다릅니다.
테스트 2
입력값 〉	"TOBEORNOTTOBEORTOBEORNOT"
기댓값 〉	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
실행 결과 〉	실행한 결괏값 []이(가) 기댓값 [20,15,2,5,15,18,14,15,20,27,29,31,36,30,32,34]와(과) 다릅니다.
테스트 3
입력값 〉	"ABABABABABABABAB"
기댓값 〉	[1, 2, 27, 29, 28, 31, 30]
실행 결과 〉	실행한 결괏값 []이(가) 기댓값 [1,2,27,29,28,31,30]와(과) 다릅니다.
테스트 4
입력값 〉	"THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS"
기댓값 〉	[20, 8, 1, 20, 27, 29, 9, 19, 33, 31, 30, 28, 20, 33, 14, 15, 39, 19, 41, 43, 36, 9, 39, 46, 38, 47, 34, 19, 36, 52, 45, 40, 42, 35, 38, 48, 62, 54, 51, 61, 53, 55, 66, 57, 44, 59, 64, 32, 49, 60, 29, 52, 76, 37, 32, 71, 43, 70, 47, 75, 73, 80, 43, 79, 56, 72, 84, 61, 86, 68, 81, 90, 69, 92, 72, 85, 63, 96, 89, 87, 91, 83, 101, 94, 103, 65, 97, 106, 99, 108, 50, 74, 111, 77, 66, 98, 81, 70, 93, 118, 117, 88, 33, 122, 116, 58, 127, 62, 127, 78, 114, 123, 100, 133, 95, 112, 105, 104, 132, 145, 87, 134, 130, 129, 137, 131, 82, 79, 148, 151, 150, 144, 153, 159, 102, 135, 121, 156, 159, 125, 75, 162, 113, 158, 124, 109, 126, 149, 67, 142, 146, 166, 155, 158, 174, 171, 140, 119, 128, 175, 120, 138, 152, 161, 174, 181, 139, 154, 141, 187, 143, 176, 165, 172, 167, 191, 164, 182, 194, 184, 136, 170, 193, 147, 86]
        * */
    }
}
