package huawei;

import java.util.ArrayList;
import java.util.List;

public final class Demo {

    /*****************************************************************************
     * Description  : 两个任意长度的长数相乘, 输出结果
     * Input Param  :
     * String multiplierA  乘数A
     * String multiplierB  乘数B
     * Return Value :
     * 乘法结果；如果数据异常，返回null
     *****************************************************************************/
    public static String multiply(String multiplierA, String multiplierB) {

        if (!isNumber(multiplierA) || !isNumber(multiplierB)) {
            throw new IllegalArgumentException("参数错误");
        }




        return null;
    }

    /**
     * 判断一个数字是否是一个合法的数字串
     *
     * @param n 待匹配字符串
     * @return true：合法数字串，false：非法字符串
     */
    public static boolean isNumber(String n) {

        if (n == null) {
            return false;
        }
        n = n.trim();

        return n.matches("([+-]?)(\\d+)((.?)(\\d*))?") || n.matches("([+-]?)((\\d*)(.?))?(\\d+)");
    }

    /**
     * 将数字符串的进行归整（整理成正规的数字字符串）00.1-->0.1 .1->0.1 0.-->0   0.000->0
     *
     * @param s 待归整的字符串
     * @return 归整后的字符串
     */
    public static String format(String s) {

        if (s != null) {
            // 去掉前导0
            int pos = 0;
            while (pos < s.length() && s.charAt(pos) == '0') {
                pos++;
            }
            // 全零串
            if (pos >= s.length()) {
                return "0";
            }

            // 小数点前都是零，要保留小数点前的第一个零
            if (s.charAt(pos) == '.') {
                pos--;
            }
            s = s.substring(pos);

            // 如果有小数点，就要去掉尾部零
            if (s.contains(".")) {
                // 去掉尾部0
                pos = s.length() - 1;
                while (s.charAt(pos) == '0') {
                    pos--;
                }
                // 小数点后都是零的情况
                if (s.charAt(pos) == '.') {
                    pos--;
                }

                s = s.substring(0, pos + 1);
            }
        }

        return s;
    }

    /**
     * 将数字字符串转成数字链表，从左到右为从低位到高位，去掉小数点
     *
     * @param s 数字字符串
     * @return 数字链表
     */
    public static List<Integer> strToArr(String s) {
        List<Integer> list = new ArrayList<Integer>(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                list.add(c - '0');
            }
        }

        return list;
    }
}


