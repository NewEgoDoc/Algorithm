package algorithm.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2거리두기확인하기 {
    public static class Coordinate{
        int x;
        int y;
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    //두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다.
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        String[][] copyPlaces = new String[places.length][5];

        for(int i = 0; i < places.length; i++){
            for(int j = 0; j < places[i].length; j++){
                copyPlaces[i][j] = places[i][j];
            }
        }
        for(int i = 0; i < copyPlaces.length; i++) {
            answer[i] = 1;
            for (int j = 0; j < copyPlaces[i].length; j++) {
                for(int k = 0; k < copyPlaces[i][j].length(); k++){
                    if(copyPlaces[i][j].charAt(k) == 'P'){
                        if(bfs(copyPlaces[i],j,k) == 0) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
                if(answer[i] == 0){
                    break;
                }
            }
        }
        return answer;
    }

    public static int bfs(String[] strArr,int i, int j){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(new Coordinate(i,j));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Coordinate now = queue.poll();
            for(int a = 0; a < 4; a++){
                int nx = now.x + dx[a];
                int ny = now.y + dy[a];
                int distance = Math.abs(nx - i) + Math.abs(ny - j);

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny] || distance > 2) continue;

                visited[nx][ny] = true;

                if(strArr[nx].charAt(ny) == 'P') return 0;
                if(strArr[nx].charAt(ny) == 'O') queue.add(new Coordinate(nx,ny));
            }
        }

        return 1;
    }


    public static void main(String[] args){
        String[][] places = {{"POOOP",
                              "OXXOX",
                              "OPXPX",
                              "OOXOX",
                              "POXXP"},
                             {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                             {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                             {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                             {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[] answer = solution(places);
        for(int i = 0; i< answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
