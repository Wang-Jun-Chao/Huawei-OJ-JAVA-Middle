import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-19 08:35
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));

        do {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            System.out.println(drinkSoda(n));

        } while (true);

        scanner.close();
    }

    private static int drinkSoda(int n) {

        int rst = 0;

        while (n >= 3) {
            // 本次换可以喝的瓶数
            rst += n / 3;
            // 喝完后手里还剩下多少个空瓶子
            n = n / 3 + n % 3;
        }

        // 最后还剩两个瓶子，可以借一瓶来喝，喝完又有三个瓶子，又可以换一瓶，将这瓶归还
        if (n == 2) {
            rst++;
        }

        return rst;
    }
}
