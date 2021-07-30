package algorithm.kakao;

import java.util.Stack;

public class 크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i< moves.length; i++){
            int move = moves[i]; //현재 move
            System.out.println("move: " + move);
            for(int j =0; j < board.length; j++){//해당 줄 보자
                int p = board[j][move-1];//해당 줄의 값을 하나씩 탐색

                if(p > 0){// 그값이 0보다 크다는것은 옮겨야한다는것을 의미
                    if(!stack.isEmpty() && stack.peek() == p){
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][move-1]);
                    }
                    board[j][move-1] = 0;
                    break;
                }
            }
            System.out.println("stack:"+ stack);
        }

        return answer;
    }

    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println("answer:"+solution(board,moves));
    }
}
