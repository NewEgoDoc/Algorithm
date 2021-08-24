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
                visited[i] = true;
                permutation(arr,visited,index+1,start,n,r);
                visited[i] = false;
            }
        }
    }
}
