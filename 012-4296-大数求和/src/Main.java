import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-19 09:41
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println(add(a, b));
        }

        scanner.close();
    }

    private static String add(String a, String b) {

        // 保证前一个字符串不比后一个长
        if (a.length() > b.length()) {
            add(b, a);
        }

        int[] arr = new int[a.length()];
        int[] brr = new int[b.length()];

        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i] = a.charAt(j) - '0';
        }

        for (int i = 0, j = brr.length - 1; i < brr.length; i++, j--) {
            brr[i] = b.charAt(j) - '0';
        }

        int carry = 0;

        int idx = 0;
        while (idx < arr.length) {
            int sum = (arr[idx] + brr[idx] + carry);
            brr[idx] = sum % 10;
            carry = sum / 10;
            idx++;
        }

        while (carry != 0 && idx < brr.length) {
            brr[idx] = (brr[idx] + carry) % 10;
            carry = (brr[idx] + carry) / 10;
            idx++;
        }

        StringBuilder builder = new StringBuilder();

        // 最后还有一个进位
        if (carry != 0) {
            builder.append(1);

            for (int i = brr.length - 1; i >= 0; i--) {
                builder.append(brr[i]);
            }

        } else {
            idx = brr.length - 1;

            // 从后面开始找第一个非0数字的位置
            // 防止下面两个数字相加，有前导0
            // 0000011111999911000000
            // 0000011111999911000000
            while (idx > 0 && brr[idx] == 0) {
                idx--;
            }


            for (int i = idx; i >= 0; i--) {
                builder.append(brr[i]);
            }
        }




        return builder.toString();
    }
}
