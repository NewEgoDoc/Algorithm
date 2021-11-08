package algorithm.복습.programmers.Lv1;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length; //잃어버린애들 전체 수에서 빼주기

        //잃어버린애가 두벌가져온애인지 확인(참 : -10 대입, reserve자격박탈)
        for(int i =0; i<reserve.length; i++){
            for(int j =0; j<lost.length; j++){
                //자격박탈된애들 빼주기
                if(lost[j]==-10 && reserve[i]==-10){
                    continue;
                }
                //reserve 자격 박탈
                if(lost[j]==reserve[i]){
                    lost[j]=-10;
                    reserve[i]=-10;
                    answer++;
                }
            }
        }
        for(int i =0; i<lost.length; i++){
            for(int j =0; j<reserve.length; j++){
                if(lost[i]==-10 || reserve[j]==-10){
                    continue;
                }
                //바로
                if(Math.abs(lost[i]-reserve[j])==1){
                    answer++;
                    reserve[j]=-10;
                    break;
                }
            }
        }

        return answer;
    }
}
