package algorithm.kakao;

public class Lv1키패드누르기 {
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        for(int i=0; i < numbers.length; i++){
            if(numbers[i] == 0) {//0일 경우는 11로 두고
                numbers[i] = 11;
            }

            if(numbers[i]%3 == 0) {//3 6 9 일 경우
                sb.append("R");
                right = numbers[i];
            } else if(numbers[i]%3 == 1) {// 1 4 7 일 경우
                sb.append("L");
                left = numbers[i];
            } else if(numbers[i]%3 == 2) {//2 5 8 0 일 경우
                int leftToCenter;
                if(numbers[i] > left) leftToCenter = numbers[i] - left;
                else leftToCenter = left - numbers[i];

                int rightToCenter;
                if(numbers[i] > right) rightToCenter = numbers[i] - right;
                else rightToCenter = right - numbers[i];

                int distance1 = (leftToCenter/3) + (leftToCenter%3);
                int distance2 = (rightToCenter/3) + (rightToCenter%3);

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
