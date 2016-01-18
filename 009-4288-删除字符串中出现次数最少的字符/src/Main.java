import java.util.Scanner;

/**
 * Author: Íõ¿¡³¬
 * Date: 2016-01-18 22:23
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(deleteLeastAppear(input));
        }

        scanner.close();
    }

    private static String deleteLeastAppear(String s) {

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int leastAppear = Integer.MAX_VALUE;

        for (int v : freq) {
            if (v > 0 && leastAppear > v) {
                leastAppear = v;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] > leastAppear) {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}
