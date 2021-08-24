package algorithm.concept;

public class Combination {
    /**
     * arr = 내가 뽑을 배열
     * visited = 중복을 막기위한 장치
     * start = 이 숫자 전으로는 안뽑을 것이다.
     * n C r
     * start로부터 n개까지중에 r개를 뽑는 combination
    * */
    public static void combination(int[] arr, boolean[] visited, int start, int n, int r){
        if(r == 0){
            // 뽑은 조합을 print
            // 또는 static 변수로 어떠한 카운트를 올려서 몇개의 조합이 있는지 셀 수 있다.
            for(int i = 0; i < arr.length; i++){
                if(visited[i]) System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < n; i++){
            visited[i] = true; //해당 위치를 방문 체크 해주고
            combination(arr,visited,i+1,n,r-1);//방문 위치 뒤로는 후보에서 제외된다 그리고 뽑을 개수도 한개 줄어들게됨
            visited[i] = false;//모두 돌았으면 방문체크를 풀어준다.
        }
    }

    public static void main(String[] args){
        int[] arr = {1,5,8,9,15,17};
        boolean[] visited = new boolean[arr.length];
        combination(arr,visited,0,6,3);
    }

}
