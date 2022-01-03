package algorithm.study.programmers.Lv1;

public class Lv1하샤드수 {
    public boolean solution(int x){
        int sumNumber = sumDigit(x);
        return x % sumNumber == 0;
    }

    private int sumDigit(int x) {
        return Integer.toString(x).chars().map(Character::getNumericValue).sum();
    }

    /*
    private int sumDigit(int x) {
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x/=10;
        }
        return 0;
    }
    */
}
