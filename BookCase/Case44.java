package BookCase;
class Test{
    public static void main(String[] args) {
        System.out.println(new Case44().digitAtIndex(19));
    }
}
public class Case44 {
    public int digitAtIndex(int index){
        if(index < 0)
            return -1;
        int digits = 1;
        while (true){
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits){
                return digitAtIndex(index,digits);
            }
            index -= digits * numbers;
            digits++;
        }
    }

    private int countOfIntegers(int digits){
        if(digits == 1)
            return 10;
        // 2位 90  3 位 900 ……
        int count = (int) Math.pow(10,digits - 1);
        return 9 * count;
    }

    private int digitAtIndex(int index, int digit){
        int number = beginNumber(digit) + index / digit;
        int indexFromRight = digit - index % digit;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10 ;
    }

    private int beginNumber(int digits){
        if(digits == 1)
            return 0;
        return (int)Math.pow(10,digits-1);
    }
}
