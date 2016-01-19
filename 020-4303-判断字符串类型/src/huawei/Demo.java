package huawei;


public final class Demo {

	/*
    功能: 根据一组规则识别一个特定的字符串是常见的计算机问题，

	定义了如下三种字符串类型：

	Slump是一串字符，具有如下性质：
	    1.以'D'或'E'开始
	    2.第一个字符后由1个或多个'F'
	    3.之后跟着一个Slump或'G'，至此一个Slump结束。
	    4.其他的都不是Slump

	例如，DFFEFFFG是Slump

	Slimp是一串字符，具有如下性质：
	    1.第一个字符是'A'
	    2.如果Slimp只有2个字符，则第二个字符是'H'
	    3.如果大于2个字符，则可能有2种形式
	        a) 'A'后接一个'B'再接一个Slimp再接一个'C'
	        b) 'A'后接一个Slump再接一个'C'
	    4.其他的都不是Slimp

	Slurpy是一个Slimp后接一个Slump组成

	请编写程序判断一个字符串是否为Slurpy

	输入: 一个字符串
	    
	输出: 无
	     
	返回: 1，是Slurpy
	      0，不是
	     
	*/

    public static int isSlurpy(String str) {

        if (str == null || str.length() < 1) {
            return 0;
        }

        int[] rst = {0};
        boolean rs = isSlimp(str, 0, rst);
        // 不是
        if (!rs) {
            return 0;
        }

        rs = isSlump(str, rst[0] + 1, rst);

        // 不是
        if (!rs) {
            return 0;
        }

        if (str.length() == (rst[0] + 1)) {
            return 1;
        } else {
            return 0;
        }

    }

    // 判断Slump前缀
    public static boolean isSlump(String s, int i, int[] rst) {

        // 字符示全部处理完
        if (s.length() <= i) {
            return false;
        }

        char c = s.charAt(i);
        // 第一个字母是D或者E才是Slump字符串
        if (c != 'D' && c != 'E') {
            return false;
        }

        i++;
        if (s.length() <= i) {
            return false;
        }

        c = s.charAt(i);
        // 第二个字符串必须是F
        if (c != 'F') {
            return false;
        }

        i++;
        // 处理F之后的F
        // F之后的第一个非F
        while (i < s.length() && s.charAt(i) == 'F') {
            i++;
        }

        // 第一个F后要么没有字符了，要么都是F
        // 不是Slump字符串
        if (s.length() <= i) {
            return false;
        }

        if (s.charAt(i) == 'G') {
            // Slump字符串的最后一个字符位置
            rst[0] = i;
            return true;
        } else {
            // F后可能跟着一个Slump字符串
            return isSlump(s, i, rst);
        }

    }

    public static boolean isSlimp(String s, int i, int[] rst) {
        // 字符示全部处理完
        if (s.length() <= i) {
            return false;
        }

        // 第一个字符必须是A
        if (s.charAt(i) != 'A') {
            return false;
        }

        i++;
        // 如果没有第二个字符
        if (s.length() <= i) {
            return false;
        }
        // 只有两个字符的情况
        if (s.charAt(i) == 'H') {
            // Slimp字符串的结束位置
            rst[0] = i;
            return true;
        } else if (s.charAt(i) == 'B') {
            isSlimp(s, i + 1, rst);
            i = rst[0] + 1;
            if (s.length() <= i) {
                return false;
            } else if (s.charAt(i) == 'C') {
                // Slimp字符串的结束位置
                rst[0] = i;
                return true;
            } else {
                return false;
            }
        } else {
            boolean rs = isSlump(s, i, rst);
            if (!rs) {
                return false;
            } else {

                i = rst[0] + 1;

                if (s.length() <= i) {
                    return false;
                } else if (s.charAt(i) == 'C') {
                    // Slimp字符串的结束位置
                    rst[0] = i;
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

}


