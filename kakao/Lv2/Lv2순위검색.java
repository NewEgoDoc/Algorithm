package algorithm.kakao.Lv2;

import java.util.Arrays;

public class Lv2순위검색 {

    public static int CPP = 1;
    public static int JAVA = 2;
    public static int PYTHON = 3;
    public static int BACKEND = 1;
    public static int FRONTEND = 2;
    public static int JUNIOR = 1;
    public static int SENIOR = 2;
    public static int CHICKEN = 1;
    public static int PIZZA = 2;

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int[][] infoTable = new int[info.length][5];

        for(int i = 0; i < info.length; i++){
            String[] infos = info[i].split(" ");
            if(infos[0].equals("cpp")) infoTable[i][0] = CPP;
            else if(infos[0].equals("java")) infoTable[i][0] = JAVA;
            else if(infos[0].equals("python")) infoTable[i][0] = PYTHON;

            if(infos[1].equals("backend")) infoTable[i][1] = BACKEND;
            else if(infos[1].equals("frontend")) infoTable[i][1] = FRONTEND;

            if(infos[2].equals("junior")) infoTable[i][2] = JUNIOR;
            else if(infos[2].equals("senior")) infoTable[i][2] = SENIOR;

            if(infos[3].equals("chicken")) infoTable[i][3] = CHICKEN;
            else if(infos[3].equals("pizza")) infoTable[i][3] = PIZZA;

            infoTable[i][4] = Integer.parseInt(infos[4]);
        }

        for(int i = 0; i < query.length; i++){
            String[] cndtns = query[i].split(" and ");
            int[] conditions = new int[cndtns.length +1 ];
            boolean[] satisfied = new boolean[info.length];

            for(int j = 0; j < satisfied.length; j++){
                satisfied[j] = true;
            }

            if(cndtns[0].equals("cpp")) conditions[0] = CPP;
            else if(cndtns[0].equals("java")) conditions[0] = JAVA;
            else if(cndtns[0].equals("python")) conditions[0] = PYTHON;
            else if(cndtns[0].equals("-")) conditions[0] = -1;

            if(cndtns[1].equals("backend")) conditions[1] = BACKEND;
            else if(cndtns[1].equals("frontend")) conditions[1] = FRONTEND;
            else if(cndtns[1].equals("-")) conditions[1] = -1;

            if(cndtns[2].equals("junior")) conditions[2] = JUNIOR;
            else if(cndtns[2].equals("senior")) conditions[2] = SENIOR;
            else if(cndtns[2].equals("-")) conditions[2] = -1;

            String[] subcndtn=cndtns[3].split(" ");

            if(subcndtn[0].equals("chicken")) conditions[3] = CHICKEN;
            else if(subcndtn[0].equals("pizza")) conditions[3] = PIZZA;
            else if(subcndtn[0].equals("-")) conditions[3] = -1;

            conditions[4] = Integer.parseInt(subcndtn[1]);

            Arrays.sort(infoTable,(o1, o2) -> {
                if(o1[4] < o2[4]){
                    return -1;
                }else if(o1[4] > o2[4]){
                    return 1;
                }else {
                    return 0;
                }
            });

            int index = 0;

            int start = 0;
            int end= infoTable.length;
            int mid;

            while(end - start > 0){
                mid = (end+start)/2;
                if(infoTable[mid][4] >= conditions[4]){
                    end = mid;
                } else {
                    start = mid+1;
                }
            }

            index = start;
/*
            for(int j = 0; j < conditions.length; j++){
                for(int k = 0; k < 5; k++){
                    System.out.print(infoTable[j][k] + " ");
                }
                System.out.println();
            }

            System.out.println("index: "+ index +" conditions[4]: "+conditions[4]);
*/

            for(int j = 0; j < conditions.length -1; j++){

                if(conditions[j] < 0){
                    continue;
                }

                for(int k = 0; k < infoTable.length; k++){
                            System.out.println(infoTable[k][j] +" "+ conditions[j]);
                    if(satisfied[k]){
                        if(j  <= 3){
                            if(infoTable[k][j] != conditions[j]){
                                satisfied[k] = false;
                                continue;
                            }
                        }
                    }
                }
            }

            int num = 0;
            for(int j = index; j < satisfied.length; j++){
                if(satisfied[j]) num++;
            }

            answer[i] = num;

        }

        return answer;
    }
    public static void main(String[] args){
        String[] info = {"java backend junior pizza 150",
                         "python frontend senior chicken 210",
                         "python frontend senior chicken 150",
                         "cpp backend senior pizza 260",
                         "java backend junior chicken 80",
                         "python backend senior chicken 50"};
        String[] query ={"java and backend and junior and pizza 100",
                         "python and frontend and senior and chicken 200",
                         "cpp and - and senior and pizza 250",
                         "- and backend and senior and - 150",
                         "- and - and - and chicken 100",
                         "- and - and - and - 150"};
        int[] answers = solution(info,query);
        for(int answer: answers){
            System.out.print(answer + " ");
        }
        System.out.println();
    }
}
