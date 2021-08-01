package algorithm.kakao;

import java.util.Stack;

public class Lv1비밀지도 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Stack<Integer> stack = new Stack<Integer>();

        String[][] maze = new String[n][n];

        for(int i = 0; i< arr1.length; i++){
            int x = arr1[i];
            while(x!=0){
                stack.push(x%2);
                x/=2;
            }
            while(stack.size() < n){
                stack.push(0);
            }

            for(int j=0; j < n; j++){
                if(stack.peek() == 1){
                    maze[i][j] = "#";
                } else {
                    maze[i][j] = " ";
                }
                stack.pop();
            }
        }

        for(int i = 0; i< arr2.length; i++){
            int x = arr2[i];
            while(x!=0){
                stack.push(x%2);
                x/=2;
            }
            while(stack.size() < n){
                stack.push(0);
            }

            for(int j=0; j < n; j++){
                if(stack.peek() == 1){
                    maze[i][j] = "#";
                }
                stack.pop();
            }
        }

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                sb.append(maze[i][j]);
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
    public static void main(String[] args){
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

        String[] str = solution(n,arr1,arr2);

        for(int i =0; i< str.length; i++){
            System.out.println(str[i]);
        }
    }
}
