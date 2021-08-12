package algorithm.kakao.Lv2;

import algorithm.kakao.Lv1실패율;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        List<String> file = new ArrayList<String>();

        for(int i = 0; i < files.length; i++){
            file.add(files[i]);
        }
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String x = o1;
                String y = o2;
/*
                if(o1 > o2){
                    return -1;
                } else if(o1 < o2){
                    return 1;
                } else {
                    if(o1 > o2){
                        return 1;
                    } else if(o1 < o2){
                        return -1;
                    } else {
                        return 0;
                    }
                }

*/
            return 0;
            }
        };
        return files;
    }
    public static void main(String[] args){
        String[] files ={"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(solution(files));
    }
}
