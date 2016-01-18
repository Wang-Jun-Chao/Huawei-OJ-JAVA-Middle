package huawei;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public final class Demo {

    public static String calcNN(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("参数不能小于0");
        }

        if (n < 2) {
            return "1";
        }

        int count = countDigit(n);

        // 保存结果
        int[] rst = new int[count * n];
        // 中间结果
        int[] partialRst = new int[count * n];

        partialRst[0] = 1;

        for (int v = 2; v <= n; v++) {
            int[] mul = getNumArr(v);

            clear(rst);

            for (int i = 0; i < mul.length; i++) {
                int carry = 0;
                for (int j = 0; j < partialRst.length && mul[i] != 0; j++) {

                    // mul[i]*partialRst[j]的积要算在i+j位上，
                    // rst[i + j]上原来的值
                    // carry，来自低位的进位
                    int sum = mul[i] * partialRst[j] + rst[i + j] + carry;


                    // 保证最高有效位被执行完
                    if (sum == 0 && i + j >= rst.length - 1) {
                        break;
                    } else {
                        // 下一位的进位
                        carry = sum / 10;
                        // 当前位的和
                        rst[i + j] = sum % 10;
                    }
                }
            }

            // 新计算出来的结果，作为新的中间结果，
            System.arraycopy(rst, 0, partialRst, 0, rst.length);

        }

        // 从后向前找，找第一个非0数字
        int idx = rst.length - 1;
        while (rst[idx] == 0) {
            idx--;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = idx; i >= 0; i--) {
            builder.append(rst[i]);
        }

        return builder.toString();
    }

    private static void clear(int[] rst) {
        for (int i = 0; i < rst.length; i++) {
            rst[i] = 0;
        }
    }

    // 计算一个数有多少位
    private static int countDigit(int v) {
        int count = 0;
        do {
            count++;
            v /= 10;
        } while (v != 0);
        return count;
    }

    private static int[] getNumArr(int n) {


        String s = n + "";
        int[] rst = new int[s.length()];
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            rst[i] = s.charAt(j) - '0';
        }

        return rst;
    }


}