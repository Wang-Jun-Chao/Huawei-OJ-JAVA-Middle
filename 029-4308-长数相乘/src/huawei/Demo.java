package huawei;

import java.util.ArrayList;
import java.util.List;

public final class Demo {

    /*****************************************************************************
     * Description  : 两个任意长度的长数相乘, 输出结果
     * Input Param  :
     * String ma  乘数A
     * String mb  乘数B
     * Return Value :
     * 乘法结果；如果数据异常，返回null
     *****************************************************************************/
    public static String multiply(String ma, String mb) {

        if (!isNumber(ma) || !isNumber(mb)) {
            return null;
        }

        // 去掉两端空格
        ma = ma.trim();
        mb = mb.trim();


        // 记录是正数还是负数
        boolean aPositive = true;
        boolean bPositive = true;

        // 去掉符号
        if (ma.charAt(0) == '+') {
            ma = ma.substring(1);
        } else if (ma.charAt(0) == '-') {
            aPositive = false;
            ma = ma.substring(1);
        }

        if (mb.charAt(0) == '+') {
            mb = mb.substring(1);
        } else if (mb.charAt(0) == '-') {
            bPositive = false;
            mb = mb.substring(1);
        }


        // 归整数字字符串
        ma = format(ma);
        mb = format(mb);

        // 记录有多少位小数
        int aDecimal = ma.indexOf('.');
        int bDecimal = mb.indexOf('.');


        if (aDecimal == -1) {
            aDecimal = 0;
        } else {
            aDecimal = ma.length() - (aDecimal + 1);
        }

        if (bDecimal == -1) {
            bDecimal = 0;
        } else {
            bDecimal = mb.length() - (bDecimal + 1);
        }

        // 记录结果的小数位数
        int decimal = aDecimal + bDecimal;

        List<Integer> arr = strToArr(ma);
        List<Integer> brr = strToArr(mb);

        List<Integer> rst = multiply(arr, brr);

        //System.out.println(rst);

        StringBuilder builder = new StringBuilder(rst.size());

        // 整数部分
        for (int i = rst.size() - 1; i >= decimal; i--) {
            builder.append(rst.get(i));
        }

        // 如果有小数
        if (decimal > 0) {
            // 添加小数点
            builder.append('.');
            for (int i = decimal - 1; i >= 0; i--) {
                builder.append(rst.get(i));
            }
        }

        // 删除前导零
        int pos = 0;
        while (pos < builder.length() && builder.charAt(pos) == '0') {
            pos++;
        }

        // 结果都是0，直接返回0
        if (pos >= builder.length()) {
            return "0";
        }

        // 如果点数点前面都是0，要保留小数点前面的一个零
        if (builder.charAt(pos) == '.') {
            pos--;
        }

        int endPos = builder.length() - 1;
        // 有小数
        if (decimal > 0) {
            // 删除尾部零

            while (builder.charAt(endPos) == '0') {
                endPos--;
            }
            // 小数点后面都是零，要删除小数点
            if (builder.charAt(endPos) == '.') {
                endPos--;
            }
        }

        String result = builder.substring(pos, endPos + 1);

        if (result.equals("0")) {
            return "0";
        }

        // 两个数异号
        if (aPositive ^ bPositive) {
            result = "-" + result;
        }

        return result;
    }

    private static List<Integer> multiply(List<Integer> arr, List<Integer> brr) {

        int num = arr.size() + brr.size() + 1;
        List<Integer> rst = new ArrayList<Integer>(num);
        for (int i = 0; i < num; i++) {
            rst.add(0);
        }


        int a;
        int b;
        int sum;
        int carry;
        for (int i = 0; i < arr.size(); i++) {
            a = arr.get(i);
            carry = 0;
            if (a == 0) {
                continue;
            }

            for (int j = 0; j < brr.size(); j++) {
                b = brr.get(j);
                sum = a * b + carry + rst.get(i + j);
                carry = sum / 10;
                rst.set(i + j, sum % 10);
            }

            int pos = brr.size() + i;
            while (carry > 0) {
                sum = carry + rst.get(pos);
                carry = sum / 10;
                rst.set(pos, sum % 10);
                pos++;
            }
        }

        return rst;
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
            // 如果是以小数点打头的
            if (s.charAt(0) == '.') {
                s = "0" + s;
            }

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


