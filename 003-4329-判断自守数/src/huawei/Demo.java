package huawei;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public final class Demo {
    /*
    Description
             判断是否是自守数
    Prototype
               public static boolean isAutoMorphicNum(int num)
    Input Param

          num  需要判断的数
    Output Param
             无
    Return Value
             true  是自守数
             false 不是自守数
    */
    public static boolean isAutoMorphicNum(int num) {

        String s = num + "";
        // 数字带符号就将符号去掉
        if (s.charAt(0) < '0' || s.charAt(0) > '9'){
            s = s.substring(1);
        }

        int[] arr = new int[s.length()];
        int[] rst = new int[s.length() * 2];

        // 将整形转换成数字数组，并且第0位是最低位
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = s.charAt(i) - '0';
        }

        // 来自低位的进位
        int carry = 0;
        // 计算积，第0位是最低位
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // arr[i]*arr[j]的积要算在i+j位上，
                // arr[i + j]上原来的值
                // carry，来自低位的进位
                int sum = arr[i] * arr[j] + rst[i + j] + carry;
                // 下一位的进位
                carry = sum / 10;
                // 当前位的和
                rst[i + j] = sum % 10;
            }

            // 还有进位
            if (carry != 0) {
                rst[i + arr.length] = carry;
                carry = 0;
            }
        }

//        BigInteger bi = new BigInteger(s);
//        System.out.println(s);
//        System.out.println(bi.multiply(bi));
//        System.out.println(Arrays.toString(rst));


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != rst[i]) {
                return false;
            }
        }

        return true;
    }


    // 下面是使用系统API的方法
    public static boolean isAutoMorphicNum2(int num) {

        if (num < 0) {
            num *= -1;
        }

        String s1 = num + "";
        BigInteger bi = new BigInteger(s1);
        String s2 = bi.multiply(bi).toString();

        return s2.endsWith(s1);

    }
}