package algorithm.kakao.Lv3;

import java.util.ArrayList;
import java.util.List;

public class Lv3불량사용자 {
    public static int solution(String[] user_id, String[] banned_id) {
        boolean flag = false;

        List<String> user_id_list = new ArrayList<>();

        for(String user: user_id){
            user_id_list.add((user));
        }
        int answer = user_id_list.size();
//-------------------------------------------------------------------------

        for(String banned: banned_id){
            if(user_id_list.size() == 0) break;
            for(String user: user_id){
                System.out.println(banned + ":" +user_id_list);

                if(banned.length() != user.length()) continue;

                flag = false;
                for(int i = 0; i < user.length(); i++){
                    if(banned.charAt(i) == '*'){
                        continue;
                    }

                    if(user.charAt(i) == banned.charAt(i)){
                        flag = true;

                    } else if(user.charAt(i) != banned.charAt(i)){
                        flag = false;
                        break;
                    }
                    System.out.println(flag);
                }

                System.out.println(flag);
                if(flag) {
                    System.out.println(user);
                    user_id_list.remove(user);
                }
                System.out.println(user_id_list);
            }
        }
        System.out.println(user_id_list);
        return answeruser_id_list.size();
    }
    public static void main(String[] args){
        String[] user_id={"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id={"fr*d*", "abc1**"};
        System.out.println(solution(user_id,banned_id));
    }
}
