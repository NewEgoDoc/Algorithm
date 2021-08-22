package algorithm.kakao.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv2튜플 {
    public static int[] solution(String s) {
        String newS = s.replace("{","").replace("}}","");

        String[] sArr = newS.split("},");
        Arrays.sort(sArr,(a,b)->(a.length()-b.length()));
        List<Integer> tuple = new ArrayList<>();

        for(int i = 0; i < sArr.length; i++){
            System.out.println("sArr["+i+"]: "+sArr[i]);
            String[] elementS = sArr[i].split(",");
            for(int j= 0; j < elementS.length; j++){
                int target = Integer.parseInt(elementS[j]);
                boolean isAdd = true;
                System.out.println("target:"+target);
                if(tuple.size() == 0){
                    tuple.add(target);
                    continue;
                }
                for(int k = 0; k < tuple.size(); k++){
                    System.out.println(target+"|"+tuple.get(k)+":"+tuple);
                    if(target == tuple.get(k)){
                        isAdd = false;
                        break;
                    }
                }
                if(isAdd){
                    tuple.add(target);
                }
            }
        }
        int[] answer = new int[tuple.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = tuple.get(i);
        }

        System.out.println(tuple);
        return answer;
    }
    public static void main(String[] args){
        String s = "{{2,1,3,4},{2},{2,1},{2,1,3}}";
        int[] a = solution(s);
        for(int i : a){
            System.out.println(i);
        }
    }
}
