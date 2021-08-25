package algorithm.kakao.Lv2;

import java.util.*;

public class Lv2메뉴리뉴얼 {
    public static void combination(String s, boolean[] visited, int start, int n, int r, List<String> list,StringBuilder sb) {
        if(r == 0) {
            list.add(sb.toString());
            return;
        }

        for(int i= start; i < n; i++){
            visited[i] = true;
            sb.append(s.charAt(i));
            combination(s,visited,i+1,n,r -1,list,sb);
            sb.deleteCharAt(sb.toString().length()-1);
            visited[i] = false;
        }
    }

    public static String[] solution(String[] orders, int[] course) {

        List<String> answer = new ArrayList<String>();
        for(int i = 0; i < course.length; i++){
            int len = course[i];

            List<String> list = new ArrayList<>();
            Map<Integer,ArrayList<String>> map = new HashMap<>();

            for(int j=0; j < orders.length; j++){
                char[] charArr = orders[j].toCharArray();
                Arrays.sort(charArr);
                String str = new String(charArr);

                boolean[] visited = new boolean[str.length()];
                StringBuilder sb = new StringBuilder();
                combination(str,visited,0,str.length(),len,list,sb);
            }

            Set<String> set = new HashSet<>(list);
            int max = 0;
            int count = 0;
            Iterator<String> iterator = set.iterator();
            while(iterator.hasNext()){
                String x = iterator.next();
                count = 0;
                for(String s: list){
                    if(x.equals(s)) count++;
                }
                if(max < count){
                    if(count >=2) {
                        for (Object a : answer.toArray()) {//앞서 들어가있던 해당 길이의 문자들을 제거
                            if (((String) a).length() == len) answer.remove((String) a);
                        }
                        answer.add(x);//가장긴 길이의 문자 정답 리스트에 넣고
                        max = count;//max값 최신화
                    }
                } else if(max == count){//같아도 들어감
                    if(count >= 2) answer.add(x);// 대신 max값 최신화는 없음
                }
            }
            Collections.sort(answer);
            System.out.println(answer);

        }
        String[] submit = new String[answer.size()];
        for(int i = 0; i< submit.length; i++){
            submit[i] = answer.get(i);
        }
        return submit;
    }
    public static void main(String[] args){
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String[] str = solution(orders,course);

        for(String s: str){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
