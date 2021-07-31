package Algorithm.kakao;

import java.util.*;

public class 실패율 {
    public static int[] solution(int N, int[] stages) {
//N 1~500 이하의 자연수
//stages의 길이1~200,000 이하
//stages에는 1 이상 N + 1 이하의 자연수
//스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열

        int[] fail = new int[N+1];
        for(int i = 0; i < stages.length; i++){
            if(stages[i]<=N){
                fail[stages[i]]++;
            }
        }

        List<Double> failRate = new ArrayList<Double>();

        int count = 0;
        for(int i = 1; i< fail.length;i++) {
            failRate.add(1.0*fail[i]/(stages.length-count));
            count += fail[i];
        }
        System.out.println(failRate);

        Collections.sort(failRate,Collections.reverseOrder());
        count = 0;
        for(int i = 0; i< failRate.size();i++){
            failRate.get(i);
            count += fail[i];
        }
        System.out.println();
        return new int[3];
    }

    public static void main(String[] args){
        int N=5;
        int[] stages={2, 1, 2, 6, 2, 4, 3, 3};
        solution(N,stages);
    }
}
