package algorithm.concept;

public class Permutation {
    public static void main(String[] args){
        int[] arr = {1,5,8,9,15,17};
        boolean[] visited = new boolean[arr.length];
        permutation(arr,visited,0,0,6,3);
    }

    public static void permutation(int[] arr, boolean[] visited,int index, int start ,int n, int r){
        if(index == r){
            for(int i = 0 ; i < arr.length; i++){
                if(visited[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < n; i++){
            if(visited[i] == false){//방문 한적이 없다면
                visited[i] = true;//방문하고
                permutation(arr,visited,index+1,start,n,r);//인덱스만 하나로 앞으로 해주고 모두 방문해본다.
                visited[i] = false;//방문하고 나온후에는 해당 지점은 방문 취소 처리
            }
        }
    }
}
