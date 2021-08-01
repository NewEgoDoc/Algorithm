package algorithm.kakao;

import java.util.Locale;

public class Lv1신규아이디추천 {
    public static String solution(String new_id) {
        String answer="";
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase(Locale.ROOT);
        System.out.println("1:"+new_id);

        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++){
            char c = new_id.charAt(i);
            if((c>='a' && c <='z') || (c>='0' && c <='9')|| c =='-'|| c =='_'|| c =='.'){
                sb.append(c);
            }
        }
        System.out.println("2:"+sb.toString());

        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String str = sb.toString();
        while(str.contains("..")){
            str = str.replace("..",".");
        }

        System.out.println("3:"+str);

        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(str.length() != 0 && str.charAt(0) == '.'){
            str = str.substring(1);
        }

        if(str.length() != 0 && str.charAt(str.length()-1) == '.'){
            str = str.substring(0,str.length()-1);
        }

        System.out.println("4:"+str);

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(str.length() == 0){
            str = "a";
        }
        System.out.println("5:"+str);

        /*6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.*/
        sb = new StringBuilder();
        if(str.length() >= 16){
            for(int i = 0; i < 15; i++){
                if(i == 14 && str.charAt(i) == '.'){
                    continue;
                }
                sb.append(str.charAt(i));
            }
        }

        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

        else if(str.length() == 1) {
            sb.append(str.charAt(0)).append(str.charAt(0)).append(str.charAt(0));
        } else if(str.length() ==2){
            sb.append(str.charAt(0)).append(str.charAt(1)).append(str.charAt(1));
        } else {
            for(int i = 0; i < str.length(); i++){
                sb.append(str.charAt(i));
            }
        }
        System.out.println("6,7:"+sb.toString());

        return sb.toString();
    }

    public static void main(String[] args){
        String new_id = "abcdefghijklmn.p";
        System.out.println(solution(new_id));
    }
}
