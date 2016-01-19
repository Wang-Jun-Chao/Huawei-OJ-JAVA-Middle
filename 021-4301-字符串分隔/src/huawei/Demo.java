package huawei;


import java.util.LinkedList;
import java.util.List;

public final class Demo {

    /**
     * 连续输入字符串(输出次数为N,字符串长度小于100)，
     * 请按长度为8拆分每个字符串后输出到新的字符串数组，
     * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     */
    public static String[] splitString(String[] input) {

        if (input == null || input.length < 1) {
            return null;
        }

        List<String> list = new LinkedList<String>();
        int splitLen = 8;
        char[] lastPart = new char[splitLen];

        for (String s : input) {

            int pos = splitLen;
            while (pos <= s.length()) {
                list.add(s.substring(pos - splitLen, pos));
                pos += splitLen;
            }

            // 最后还有不足splitLen长度的字符串
            if (pos - s.length() < splitLen) {
                int i = 0;
                for (int j = pos - splitLen; j < s.length(); j++) {
                    lastPart[i] = s.charAt(j);
                    i++;
                }

                while (i < splitLen) {
                    lastPart[i] = '0';
                    i++;
                }

                list.add(new String(lastPart));
            }
        }

        String[] rst = new String[list.size()];

        int i = 0;
        for (String s : list) {
            rst[i] = s;
            i++;
        }

        return rst;


    }


}


