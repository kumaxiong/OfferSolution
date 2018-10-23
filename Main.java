import java.util.Scanner;

public class Main {


    // 100000000000000000
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        long m = 1;
        while (helper(num, m, 0, 0)) {
            m++;
        }
        System.out.println(m);
    }

    private static boolean helper(long num, long m, long a, long b) {
        while (num != 0) {
            if (num < m) {
                a+=num;
                num -= num;
            } else {
                a += m;
                num -= m;
            }

            long temp = num / 10;
            b += temp;
            num -= temp;
        }

        return a < b;
    }
}