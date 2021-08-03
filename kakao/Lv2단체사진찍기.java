package algorithm.kakao;

public class Lv2단체사진찍기 {//왠지 순열 조합인듯하다
    public static int solution(int n, String[] data) {
        char [] letters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        //{A, C, F, J, M, N, R, T}
        int answer = 0;
        return answer;
    }
    public static void main(String[] args){
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(solution(n,data));//3648
    }
}
