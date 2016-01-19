package huawei;


public final class Demo {

    /* 功能：将十六进制字符串形式内容转为内存值形式（注：pBuffer的内存申请由调用者保证）
     * 输入：szHexText：十六进制字符串形式，如: "6566"
     * 输出：dataOutput,其中：内存值形式Buffer，即内存的{0x65, 0x66}
     * 返回：返回转换成功的buffer的有效字节数
     */
    public static int[] hexToBin(String szHexText) {

        if (szHexText == null || szHexText.length() < 2) {
            return null;
        }

        StringBuilder builder = new StringBuilder(szHexText.length());

        for (int i = 0; i < szHexText.length(); i++) {
            char c = szHexText.charAt(i);
            if (c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F') {
                builder.append(c);
            }
        }

        if (builder.length() < 2) {
            return null;
        }

        int[] rst = new int[builder.length() / 2];

        for (int i = 0; i + 1 < builder.length(); i += 2) {
            int a = charToInt(builder.charAt(i));
            int b = charToInt(builder.charAt(i + 1));
            rst[i / 2] = a * 16 + b;
        }


        return rst;
    }

    private static int charToInt(char c) {

        if (c >= '0' && c <= '9') {
            return c - '0';
        }

        if (c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }

        if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }

        return 0;
    }


}