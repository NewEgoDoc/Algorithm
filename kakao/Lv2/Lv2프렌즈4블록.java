package algorithm.kakao.Lv2;

public class Lv2프렌즈4블록 {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[board.length][board[0].length()];
        boolean[][] check = new boolean[board.length][board[0].length()];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        boolean go = true;
        while(go){
            go = false;
            /*같은 블럭 체크*/
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){

                    if(map[i][j] == ' '){
                        continue;
                    }

                    if(map[i][j] == map[i+1][j] &&
                            map[i][j] == map[i][j+1] &&
                            map[i][j] == map[i+1][j+1]){
                        check[i][j] = true;
                        check[i+1][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j+1] = true;
                        go = true;
                    }
                }
            }

            /*개수세고*/
            for(int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(check[i][j]){
                        answer++;
                        for(int k = i; k >0; k--){
                            map[k][j] = map[k-1][j];
                        }
                        map[0][j] = ' ';

                        check[i][j] = false;
                    }
                }
            }
        }

        return answer;
    }
    public static void main(String[] args){
        int m = 5;
        int n = 6;
        String[] board = {"AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"};
        System.out.println(solution(m,n,board));
        /*
        m	n	board	answer
        4	5	["CCBDE", "AAADE", "AAABF", "CCBBF"]	14
        6	6	["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]	15
        */
    }
}
