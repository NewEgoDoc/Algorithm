package algorithm.kakao.Lv2;

import java.util.ArrayList;
import java.util.List;

public class Lv2압축 {
    public int[] solution(String msg) {
        int[] answer = {};
        List<String> dict = new ArrayList<>();
        dict.add("");
        for(int i = 0; i < 26; i++){
            dict.add(String.valueOf((char)('A'+i)));
        }

        for(int i = 0; i < msg.length();){
            int x = 1;
            boolean flag = false;
            int index = 1;
            while(true){
                String str = msg.substring(i,i+x);
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
                if(count == dict.size() -1) break;
                x++;
            }
            i += x;

        }

        return answer;
    }
}
