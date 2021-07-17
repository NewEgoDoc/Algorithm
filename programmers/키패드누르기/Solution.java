package algorithm.programmers.키패드누르기;

public class Solution {
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        for(int i=0; i < numbers.length; i++){
            if(numbers[i] == 0) {
                numbers[i] = 11;
            }
            if(numbers[i]%3 == 0) {
                sb.append("R");
                right = numbers[i];
            } else if(numbers[i]%3 == 1) {
                sb.append("L");
                left = numbers[i];
            } else if(numbers[i]%3 == 2) {
                int standard1;
                if(numbers[i] > left) standard1 = numbers[i] - left;
                else standard1 = left - numbers[i];
                
                int standard2;
                if(numbers[i] > right) standard2 = numbers[i] - right; 
                else standard2 = right - numbers[i];
                
                int distance1 = (standard1/3) + (standard1%3);
                int distance2 = (standard2/3) + (standard2%3);
                if(distance1 < distance2) {
                    sb.append("L");
                    left = numbers[i];
                } else if(distance1 > distance2) {
                    sb.append("R");
                    right = numbers[i];
                } else {
                    if(hand.equals("right")) {
                        sb.append("R");
                        right = numbers[i];
                    } else {
                        sb.append("L");
                        left = numbers[i];
                    }
                }
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    	String hand = "right";
    	System.out.println(solution(numbers, hand));
    }
}
