package huawei;

public final class Demo {

	
	/*
    功能: 输入的基准字符串中统计指定字符出现的频率
	      字符串仅包括英文大小写字母和空格、逗号、点号
		  小数点后保留2位有效数字，第三位四舍五入

	输入: String pString  输入的基准字符串
		 char c 指定的字符
	
	返回: 输出指定字符出现的频率
	*/

    public static float getRateFromString(String pString, char c) {

        if (pString == null || pString.length() < 1) {
            return 0.00F;
        }


        float count = 0;
        for (int i = 0; i < pString.length(); i++) {
            if (pString.charAt(i) == c) {
                count += 1;
            }
        }


        count = count / pString.length();

        int i = (int) (count * 1000 + 5) / 10;

        return (i / 100.0F);
    }

}