import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-19 22:29
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine().trim();
            System.out.println(intSort(input));
        }

        scanner.close();
    }

    private static String intSort(String s) {
        String[] ss = s.split(",");
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = Integer.parseInt(ss[i]);
        }

        Arrays.sort(arr);

        StringBuilder builder = new StringBuilder();
        builder.append(arr[0]).append(' ');

        for (int i = 1; i < arr.length; i++) {
            // 下标为i的元素可以被删除的条件
            if (i + 1 < arr.length && arr[i - 1] + 1 == arr[i] && arr[i] == arr[i + 1] - 1) {
                continue;
            }

            builder.append(arr[i]).append(' ');

        }


        return builder.substring(0, builder.length() - 1);
    }
}
