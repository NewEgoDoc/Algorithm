package Algorithm.kakao;

public class 다트게임 {
    public static int solution(String dartResult) {
        int stage[] = new int[3];
        int phase = -1;

        for(int i = 0; i < dartResult.length(); i++){
            if(dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9'){
                phase++;// 0 1 2
                if(dartResult.charAt(i) == '1' && dartResult.charAt(i+1) == '0'){
                    stage[phase] = 10;
                    i++;
                } else {
                    stage[phase] = dartResult.charAt(i) - '0';
                }
            }

            else if(dartResult.charAt(i) == 'S'){
                stage[phase] = (int)Math.pow(stage[phase],1);
            } else if(dartResult.charAt(i) == 'D'){
                stage[phase] = (int)Math.pow(stage[phase],2);
            } else if(dartResult.charAt(i) == 'T'){
                stage[phase] = (int)Math.pow(stage[phase],3);
            }

            else if(dartResult.charAt(i) == '*'){
                if(phase > 0) {
                    stage[phase-1] *= 2;
                }
                stage[phase] *= 2;
            } else if(dartResult.charAt(i) == '#'){
                stage[phase] *= -1;
            }
        }
        return stage[0] + stage[1] + stage[2];
    }
    public static void main(String[] args){
        String dartResult="1S2D*3T";
        System.out.println(solution(dartResult));
    }
}
