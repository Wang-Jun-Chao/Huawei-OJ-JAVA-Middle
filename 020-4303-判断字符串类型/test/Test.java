import huawei.Demo;

/**
 * Author: Íõ¿¡³¬
 * Date: 2016-01-19 15:54
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Test {
    public static void main(String[] args) {

//        testIsSlump();
//        testIsSlimp();
        testIsSlurpy();
    }

    private static void testIsSlurpy() {
        // 1
        System.out.println(Demo.isSlurpy("AHEFG"));
        System.out.println(Demo.isSlurpy("AHDFG"));
        System.out.println(Demo.isSlurpy("ABAHCEFG"));
        System.out.println(Demo.isSlurpy("ABAHCDFG"));
        System.out.println(Demo.isSlurpy("ABABAHCCDFG"));

        // 0
//        System.out.println(Demo.isSlurpy("AHEFGF"));
    }

    private static void testIsSlimp() {
//        System.out.println(Demo.isSlimp("AH", 0, new int[]{1}));
//        System.out.println(Demo.isSlimp("ABAHC", 0, new int[]{1}));
//        System.out.println(Demo.isSlimp("ABABAHCC", 0, new int[]{1}));
//        System.out.println(Demo.isSlimp("ADFGC", 0, new int[]{1}));
    }

    private static void testIsSlump() {
        System.out.println(Demo.isSlump("DFG", 0, new int[]{1}));
        System.out.println(Demo.isSlump("EFG", 0, new int[]{1}));
        System.out.println(Demo.isSlump("DFFG", 0, new int[]{1}));
        System.out.println(Demo.isSlump("EFFFG", 0, new int[]{1}));

        System.out.println(Demo.isSlump("EFFFG????", 0, new int[]{1}));


        System.out.println(Demo.isSlump("EFFFEFG", 0, new int[]{1}));
        System.out.println(Demo.isSlump("EFFFEFDFG", 0, new int[]{1}));

        System.out.println(Demo.isSlump("EFFFEFG???", 0, new int[]{1}));
        System.out.println(Demo.isSlump("EFFFEFDFG???", 0, new int[]{1}));


    }
}
