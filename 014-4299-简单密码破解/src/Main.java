import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-19 10:24
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    // 掩码表
    private final static char[][] MASK = {
            {'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6',
                    '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'},
            {'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                    'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a'}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(encrypt(input));
        }

        scanner.close();
    }

    private static String encrypt(String input) {

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // 如果是小写字母，就要转变成数字符
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = MASK[0][chars[i] - 'a'];
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = MASK[1][chars[i] - 'A'];
            }
        }


        return new String(chars);
    }
}
