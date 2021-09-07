package algorithm.kakao.Lv3;

import java.util.*;

public class Lv3불량사용자 {
    static private Set<Set<String>> result;

    public static int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        dfs(user_id, banned_id, new LinkedHashSet<>());
        return result.size();
    }

    private static void dfs(String[] user_id, String[] banned_id, Set<String> set) {
        if (set.size() == banned_id.length) {
            if (isBannedUsers(set, banned_id)) {
                result.add(new HashSet<>(set));
            }

            return;
        }

        for (String userId : user_id) {
            if (!set.contains(userId)) {
                set.add(userId);
                dfs(user_id, banned_id, set);
                set.remove(userId);
            }
        }
    }

    private static boolean isBannedUsers(Set<String> set, String[] banned_id) {
        int i = 0;

        for (String user : set) {
            if (!isSameString(user, banned_id[i++])) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSameString(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '*') continue;

            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
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
