import huawei.Demo;

import java.util.Arrays;

/**
 * Author: Íõ¿¡³¬
 * Date: 2016-01-19 13:20
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Test {
    public static void main(String[] args) {
        String[] srr = {"abc", "12345678", "123456789"};


        String[] rst ;

        for (int i = 1; i <=10 ; i++) {
            rst = Demo.convertStringArray(srr, i);
            System.out.println(Arrays.toString(rst));
        }
    }
}
