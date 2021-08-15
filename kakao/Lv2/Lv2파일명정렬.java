package algorithm.kakao.Lv2;

import java.util.*;

public class Lv2파일명정렬 {
    /*
    파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬한다. 이때, 문자열 비교 시 대소문자 구분을 하지 않는다. MUZI와 muzi, MuZi는 정렬 시에 같은 순서로 취급된다.
    파일명의 HEAD 부분이 대소문자 차이 외에는 같을 경우, NUMBER의 숫자 순으로 정렬한다. 9 < 10 < 0011 < 012 < 13 < 014 순으로 정렬된다. 숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값으로 처리된다.
    두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지한다. MUZI01.zip과 muzi1.png가 입력으로 들어오면, 정렬 후에도 입력 시 주어진 두 파일의 순서가 바뀌어서는 안 된다.
    무지를 도와 파일명 정렬 프로그램을 구현하라.

    files는 1000 개 이하의 파일명을 포함하는 문자열 배열이다.
    각 파일명은 100 글자 이하 길이로, 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")만으로 이루어져 있다. 파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.
    중복된 파일명은 없으나, 대소문자나 숫자 앞부분의 0 차이가 있는 경우는 함께 주어질 수 있다. (muzi1.txt, MUZI1.txt, muzi001.txt, muzi1.TXT는 함께 입력으로 주어질 수 있다.)
    출력 형식
    위 기준에 따라 정렬된 배열을 출력한다.

    입출력 예제
    입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
    출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]

    입력: ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
    출력: ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]

    */

    public static String[] solution(String[] files) {
        String[] answer = {};
// 조건에 따른 정렬을 하기 위해 Comparator 구현
// compare 리턴값이 양수면 두 객체의 자리를 바꿔줌
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
// 숫자 앞부분을 잘라서 head 생성
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
// compareTo를 사용한 비교를 위해서는 모두 소문자로 변경 후 비교
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                if (result == 0) { // 같은 문자일 경우 숫자로 비교
                    result = convertNum(o1, head1) - convertNum(o2, head2);
                }
                return result;
            }
        });
        return files;
    }
    public static int convertNum(String str, String head) {
        str = str.substring(head.length()); // head 길이만큼 잘라서 숫자부터 시작하게 만들어줌
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && result.length() < 5) // 숫자인지 그리고 result 길이가 5가 안 넘는지 확인
                result += c;
            else
                break;
        }
        return Integer.valueOf(result);
    }


    /*public static String[] solution(String[] files) {
        String[] file = new String[files.length];

        for(int i = 0; i < files.length; i++){
            file[i] = files[i];
        }

        Arrays.sort(file, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String head1 = o1.split("[0-9]")[0].toLowerCase();
                String head2 = o2.split("[0-9]")[0].toLowerCase();

                int standard = head1.compareTo(head2);

                if(standard == 0){
                    int numLastIndex1 = 0;
                    int numLastIndex2 = 0;
                    for(int i = head1.length(); i < o1.length(); i++){
                        if(o1.charAt(i) < '0' || o1.charAt(i) > '9'){
                            numLastIndex1 = i;
                            break;
                        }
                    }

                    int number1 = Integer.parseInt(o1.substring(head1.length(),numLastIndex1-1));

                    for(int i = head2.length(); i < o2.length(); i++){
                        if(o2.charAt(i) < '0' || o2.charAt(i) > '9'){
                            numLastIndex2 = i;
                            break;
                        }
                    }

                    int number2 = Integer.parseInt(o2.substring(head2.length(),numLastIndex2));

                    return number1 - number2;

                } else {
                    return standard;
                }
            }
        });

        return file;
    }*/
    public static void main(String[] args){
        String[] files ={"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"};
        String[] answer = (solution(files));

        for(int i =0; i< answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
