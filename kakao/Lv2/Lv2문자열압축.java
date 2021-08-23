package algorithm.kakao.Lv2;

public class Lv2문자열압축 {
    public static int solution(String s) {
        int answer = s.length();

        for(int i = 1; i <=s.length()/2; i++){
            int now = 0;
            int len = s.length();


            while(now+i <=s.length()){
                String sub = s.substring(now,now+i);
                now += i;

                int cnt = 0;
                while(now+i <=s.length()){
                    if(sub.equals(s.substring(now,now+i))){
                        ++cnt;
                        now += i;
                    } else {
                        break;
                    }
                }

                if(cnt >0){
                    len -= i * cnt;

                    if (cnt < 9) len += 1;
                    else if (cnt < 99) len +=2;
                    else if (cnt < 999) len +=3;
                    else len += 4;
                }
            }

            answer = Math.min(answer,len);
        }

        return answer;
    }
    public static void main(String[] args){
        String s = "aabbaccc";
        System.out.println(solution(s));
    }
}
