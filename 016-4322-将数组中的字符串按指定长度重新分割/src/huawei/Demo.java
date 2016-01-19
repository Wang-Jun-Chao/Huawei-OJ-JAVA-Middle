package huawei;


import java.util.LinkedList;
import java.util.List;

public final class Demo {
    /*
    功能:请编写一个函数，输入为一个字符串数组，
	请按指定长度iInputLenth拆分数组中的每个字符串，输出到新的字符串数组中。长度不是iInputLenth整数倍的字符串请在后面补数字0。
	空字符串不处理，遇到空字符串则表示数组结束，函数返回。
	输入:
	    String inputStrArray  (srr)   字符串数组指针 字符串个数最大为50,字符串长度最大255
	    int iInputLenth (split)  指定的分割长度 iInputLenth>=1 && <=32
	     
	返回:字符串数组指针     

	示例 按长度8拆分
	输入： abc 
	       12345789 
	返回： abc00000
	       12345678
	       90000000

	*/

    public static String[] convertStringArray(String[] srr, int splitLen) {


        if (srr == null || srr.length < 1 || splitLen < 1 || splitLen > 32) {
            return null;
        }

        List<String> list = new LinkedList<String>();
        char[] lastPart = new char[splitLen];

        for (String s : srr) {

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