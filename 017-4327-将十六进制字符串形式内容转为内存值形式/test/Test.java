import huawei.Demo;

/**
 * Author: Íõ¿¡³¬
 * Date: 2016-01-19 13:42
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Test {
    public static void main(String[] args) {
        int[] rst;
        String[] srr = {"", "5656", "33ett45abc", "65#4#3", "655", "6"};

        for (String s : srr) {
            rst = Demo.hexToBin(s);

            if (rst != null) {
                for (int v : rst) {
                    System.out.print(Integer.toHexString(v) + " ");
                }

                System.out.println();
            } else {
                System.out.println("null");
            }


        }
    }
}
