package algorithm.kakao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class Lv1신규아이디추천 {
    public static String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
//      1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.

        String tmp=new_id.toLowerCase(Locale.ROOT);

//      2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for (int i = 0; i < tmp.length(); i++) {
            if((tmp.charAt(i)>='0'&& tmp.charAt(i) <='9')||
               (tmp.charAt(i)>='a'&& tmp.charAt(i) <='z')||
                tmp.charAt(i) == '-' ||
                tmp.charAt(i) == '_'||
                tmp.charAt(i) == '.'){
                sb.append(tmp.charAt(i));
            }
        }

        tmp = sb.toString();

//      3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        while(tmp.contains("..")){
            tmp = tmp.replace("..",".");
        }

        if(tmp.length() != 0){
//      4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
            if(tmp.charAt(0) == '.') tmp = tmp.substring(1);
            if(tmp.length() != 0 && tmp.charAt(tmp.length()-1) == '.') tmp = tmp.substring(0,tmp.length()-1);
        }
        if(tmp.length() == 0){
//      5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
            tmp = "a";
        }
//      6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        StringBuilder sb2 = new StringBuilder();
        if(tmp.length() > 2){
            if(tmp.length() >= 16){
                for (int i = 0; i < 15; i++) {
                    if(i == 14 && tmp.charAt(i) == '.'){
                        continue;
                    }
                    sb2.append(tmp.charAt(i));
                }
            } else {
                for (int i = 0; i < tmp.length(); i++) {
                    sb2.append(tmp.charAt(i));
                }
            }
        }
//      7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(tmp.length() <= 2){
            int len = tmp.length()-1;
            if(len == 0) {
                sb2.append(tmp.charAt(len));
                sb2.append(tmp.charAt(len));
                sb2.append(tmp.charAt(len));
            }
            if(len == 1) {
                sb2.append(tmp.charAt(0));
                sb2.append(tmp.charAt(len));
                sb2.append(tmp.charAt(len));
            }
            if(len == 2) {
                sb2.append(tmp.charAt(0));
                sb2.append(tmp.charAt(1));
                sb2.append(tmp.charAt(2));
            }
        }
        return sb2.toString();
    }

    @Test
    void test(){
        Assertions.assertEquals(solution("...!@BaT#*..y.abcdefghijklm"),"bat.y.abcdefghi");
        Assertions.assertEquals(solution("z-+.^."),"z--");
        Assertions.assertEquals(solution("=.="),"aaa");
        Assertions.assertEquals(solution("123_.def"),"123_.def");
        Assertions.assertEquals(solution("abcdefghijklmn.p"),"abcdefghijklmn");
    }
}
