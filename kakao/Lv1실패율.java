package algorithm.kakao;

import java.util.*;

public class Lv1실패율 {
    static class  Fail {
        int stage;
        double failRate;

        Fail(int stage, double failRate){
            this.failRate = failRate;
            this.stage = stage;
        }
    }



    public static int[] solution(int N, int[] stages) {
//N 1~500 이하의 자연수
//stages의 길이1~200,000 이하
//stages에는 1 이상 N + 1 이하의 자연수
//스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열
        boolean []visit = new boolean[N+1];
        int[] fail = new int[N+1];
        for(int i = 0; i < stages.length; i++){
            if(stages[i]!=N+1){
                fail[stages[i]]++;
            }
        }


        List<Fail> failObj = new ArrayList<Fail>();

        int count = 0;
        for(int i = 1; i< fail.length;i++) {
            failObj.add(new Fail(i ,1.0*fail[i]/(stages.length-count)));
            count += fail[i];
        }

        Comparator<Fail> com = new Comparator<Fail>() {
            @Override
            public int compare(Fail o1, Fail o2) {
                if(o1.failRate > o2.failRate){
                    return -1;
                } else if(o1.failRate < o2.failRate){
                    return 1;
                } else {
                    if(o1.stage > o2.stage){
                        return 1;
                    } else if(o1.stage < o2.stage){
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        };

        Collections.sort(failObj,com);
        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = failObj.get(i).stage;
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        int N = 5;
        int[] stages={2, 1, 2, 6, 2, 4, 3, 3};
        solution(N,stages);
    }
}
