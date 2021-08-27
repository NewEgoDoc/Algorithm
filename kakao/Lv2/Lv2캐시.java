package algorithm.kakao.Lv2;

import java.util.*;

public class Lv2캐시 {
    //Cache Miss라는 것은 "현재 사용하고자 하는 데이터가 Cache Memory에 존재하지 않는 경우"
    //Cache Hit라는 것은 "현재 사용하고자 하는 데이터가 Cache Memory에 존재하는 경우"

    //새로운 데이터가 들어온 경우
        //캐시에 넣어준다.
        //캐시가 가득차있다면, 가장 오래된 데이터를 제거하고 넣어준다.
    //존재하는 데이터가 들어온 경우
        //해당 데이터를 꺼낸 뒤,
        //가장 최근 데이터 위치로 보내준다.
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();

        for(int i = 0; i < cities.length; i++){
            System.out.println(cache);

            boolean isHit = false;
            if(cache.size() == 0){
                answer += 5;//Cache Miss
                cache.add(cities[i].toLowerCase(Locale.ROOT));
                continue;
            }

            for(String str: cache){
                if(str.equals(cities[i].toLowerCase(Locale.ROOT))){
                    isHit = true;
                    answer+=1;//Cache Hit
                    cache.remove(str);//해당 데이터를 꺼낸 뒤,
                    cache.add(str);//가장 최근 데이터 위치로 보내준다.
                    break;
                }
            }

            if(!isHit){
                answer += 5;
                if(cache.size() == cacheSize){
                    cache.remove(0);
                    cache.add(cities[i].toLowerCase(Locale.ROOT));
                } else {
                    cache.add(cities[i].toLowerCase(Locale.ROOT));
                }
            }
        }

        return answer;
    }
    public static void main(String[] args){
        int cacheSize= 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(solution(cacheSize,cities));
    }
    /*
3	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	50
3	["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]	21
2	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	60
5	["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]	52
2	["Jeju", "Pangyo", "NewYork", "newyork"]	16
0	["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	25
    * */
}
