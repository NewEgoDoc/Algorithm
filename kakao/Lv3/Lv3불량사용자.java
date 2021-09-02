package algorithm.kakao.Lv3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Lv3불량사용자 {
    static Set<Set<String>> set;

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        set = new HashSet<>();
        boolean[] visited = new boolean[user_id.length];
        recurr(set,visited,user_id,banned_id.length,user_id.length,banned_id.length,0);

        System.out.println();
        for(Set<String> a : set){
            System.out.println(a);

        }



//-------------------------------------------------------------------------

        return answer;
    }

    public static void recurr(Set<Set<String>> set,boolean[] visited,String[] user_id,int targetCount,int n, int r, int start){
        if(r == 0){
            Set<String> sSet = new HashSet<>();
            for(int i = 0; i < n;i++){
                if(visited[i]) sSet.add(user_id[i]);
            }

            if(sSet.size() == targetCount) {
                //System.out.println(sSet);
                //set.add(sSet);

                for(String str: sSet){

                }

            }
        }

        for(int i = start; i < n; i++){
            visited[i] = true;
            recurr(set,visited,user_id,targetCount,n,r-1,i+1);
            visited[i] = false;
        }

    }

    public static void main(String[] args){
        String[] user_id={"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id={"fr*d*", "*rodo", "******", "******"};
        System.out.println(solution(user_id,banned_id));

        /*
        *
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "abc1**"]	2
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["*rodo", "*rodo", "******"]	2
["frodo", "fradi", "crodo", "abc123", "frodoc"]	["fr*d*", "*rodo", "******", "******"]	3
        *
        * */

    }
}
