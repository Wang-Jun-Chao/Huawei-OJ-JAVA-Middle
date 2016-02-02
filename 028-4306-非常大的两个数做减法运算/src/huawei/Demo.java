package huawei;


import java.util.ArrayList;
import java.util.List;

public final class Demo {
    /*****************************************************************************
     * Description  : 两个任意长度的正数相减
     * Input Param  : String minuend   被减数，以\0表示字符串结束
     * String subtrahend  减数，以\0表示字符串结束
     * Return Value :  减法结果，必须以\0表示字符串结束
     *****************************************************************************/
    public static String decrease(String minuend, String subtrahend) {

        // 判断是不是合法的数字
        if (!isNumber(minuend) || !isNumber(subtrahend)) {
            throw new IllegalArgumentException("请输入正确的参数");
        }

        // 去掉两端空格
        minuend = minuend.trim();
        subtrahend = subtrahend.trim();


        // 记录是正数还是负数
        boolean mPositive = true;
        boolean sPositive = true;

        // 去掉符号
        if (minuend.charAt(0) == '+') {
            minuend = minuend.substring(1);
        } else if (minuend.charAt(0) == '-') {
            mPositive = false;
            minuend = minuend.substring(1);
        }

        if (subtrahend.charAt(0) == '+') {
            subtrahend = subtrahend.substring(1);
        } else if (subtrahend.charAt(0) == '-') {
            sPositive = false;
            subtrahend = subtrahend.substring(1);
        }


        // 归整数字字符串
        minuend = format(minuend);
        subtrahend = format(subtrahend);

        // 记录有多少位小数
        int mDecimal = minuend.charAt('.');
        int sDecimal = subtrahend.charAt('.');
        // 记录结果的小数位数
        int decimal = mDecimal > sDecimal ? mDecimal : sDecimal;

        if (mDecimal == -1) {
            mDecimal = 0;
        } else {
            mDecimal = minuend.length() - (mDecimal + 1);
        }

        if (sDecimal == -1) {
            sDecimal = 0;
        } else {
            sDecimal = subtrahend.length() - (sDecimal + 1);
        }
        // 被减数的小数位多
        if (mDecimal > sDecimal) {
            // 在减数后面添加零
            subtrahend = appendZero(subtrahend, mDecimal - sDecimal);
        }
        // 减数的位数不小于被减数
        else {
            // 在被减数后面添加0
            minuend = appendZero(minuend, sDecimal - mDecimal);
        }


        List<Integer> m = strToArr(minuend);
        List<Integer> s = strToArr(subtrahend);


        // 被减数是否大于等于s
        boolean isMgeS = mcompares(m, s);

        List<Integer> rst;
        // 如果被减数大于等与减数
        if (isMgeS) {
            rst = minus(m, s);
        }
        // 被减数小于减数
        else {
            rst = minus(s, m);
        }


        StringBuilder builder = new StringBuilder(rst.size() + 2);


        return null;

    }

    /**
     * m-s，前提是m大于等于s
     *
     * @param m 被减数
     * @param s 减数
     * @return 差
     */
    private static List<Integer> minus(List<Integer> m, List<Integer> s) {

        int max = m.size();
        int min = s.size();

        List<Integer> rst = new ArrayList<Integer>(max);

        // 是否被借位
        int borrow = 0;
        int i = 0;
        while (i < min) {
            int mBit = m.get(i) - borrow;
            int sBit = s.get(i);

            if (mBit >= sBit) {
                rst.add(mBit - sBit);
                borrow = 0;
            } else {
                rst.add(10 + mBit - sBit);
                borrow = 1;
            }

            i++;
        }

        while (i < max) {
            int mBit = m.get(i) - borrow;
            if (mBit >= 0 ) {
                rst.add(mBit);
                borrow = 0;
            } else {
                rst.add(10 + mBit);
                borrow = 1;
            }
        }

        return rst;
    }

    /**
     * m是否大于等于s，m和s有同样多的小数数位，并且m，s已经被归整过了
     *
     * @param m
     * @param s
     * @return
     */
    private static boolean mcompares(List<Integer> m, List<Integer> s) {

        if (m.size() > s.size()) {
            return true;
        } else if (m.size() < s.size()) {
            return false;
        } else {
            for (int i = 0; i < m.size(); i++) {
                if (m.get(i) != s.get(i)) {
                    return false;
                }
            }
        }

        return true;
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
     * 添加小数点后的尾部零
     *
     * @param s 字符串
     * @param n 添加尾部零
     * @return 添加尾部零的后的字符串
     */
    public static String appendZero(String s, int n) {
        for (int i = 0; i < n; i++) {
            s += "0";
        }

        return s;
    }

    /**
     * 将数字符串的进行归整（整理成正规的数字字符串）00.1-->0.1 .1->0.1 0.-->0.0
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
            s = s.substring(pos);

            // 如果s为空就返回零
            if (s.isEmpty()) {
                s = "0";
            } else {
                // 如果最后一个字符是点号就补后面一个零
                if (s.endsWith(".")) {
                    s += "0";
                }

                // 如果第一个是点号，就在最前页面添加一个0
                if (s.isEmpty()) {
                    s = "0" + s;
                }

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