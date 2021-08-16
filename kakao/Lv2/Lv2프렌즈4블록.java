package algorithm.kakao.Lv2;

public class Lv2프렌즈4블록 {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

            }
        }

        return answer;
    }
    public static void main(String[] args){
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(m,n,board));
        /*
        m	n	board	answer
        4	5	["CCBDE", "AAADE", "AAABF", "CCBBF"]	14
        6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	15
        */
    }
}
