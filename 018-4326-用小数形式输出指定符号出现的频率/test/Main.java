import huawei.Demo;

/**
 * Author: Íõ¿¡³¬
 * Date: 2016-01-19 14:58
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Demo.getRateFromString("wo shi, yi zhi.xiao xiao niao", ' '));
        System.out.println(Demo.getRateFromString("", ' '));
        System.out.println(Demo.getRateFromString(null, ' '));
        System.out.println(Demo.getRateFromString(" ", ' '));
    }
}
