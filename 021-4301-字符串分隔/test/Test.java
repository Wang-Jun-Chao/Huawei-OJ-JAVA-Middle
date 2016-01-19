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
        String[] srr = {"abc", "1234567", "12345678", "123456789"};


        String[] rst = Demo.splitString(srr);
        System.out.println(Arrays.toString(rst));

    }
}
