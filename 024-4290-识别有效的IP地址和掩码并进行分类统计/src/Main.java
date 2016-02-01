import java.util.Scanner;

public class Main {
    private static int[] ip = new int[4];
    private static int[] mask = new int[4];
    private static int ipA;
    private static int ipB;
    private static int ipC;
    private static int ipD;
    private static int ipE;
    private static int ipErr;
    private static int ipP;


    private static boolean checkIp(String ipStr, String maskStr) {
        String tmp;
        int maskInt = 0;

        for (int i = 0; i < 3; i++) {
            int pos = ipStr.indexOf('.');
            tmp = ipStr.substring(0, pos);

            if (tmp.isEmpty()) {
                ip[i] = -1;
            } else {
                ip[i] = Integer.parseInt(tmp);
            }
            ipStr = ipStr.substring(pos + 1);
        }

        if (ipStr.isEmpty()) {
            ip[3] = -1;
        } else {
            ip[3] = Integer.parseInt(ipStr);
        }

        for (int i = 0; i < 3; i++) {
            int pos = maskStr.indexOf('.');
            tmp = maskStr.substring(0, pos);
            if (tmp.isEmpty()) {
                mask[i] = -1;
            } else {
                mask[i] = Integer.parseInt(tmp);
            }

            maskStr = maskStr.substring(pos + 1);
        }

        if (maskStr.isEmpty()) {
            mask[3] = -1;
        } else {
            mask[3] = Integer.parseInt(maskStr);
        }

        for (int i = 0; i < 4; i++) {
            if (ip[i] < 0 || ip[i] > 255 || mask[i] < 0 || mask[i] > 255) {
                ipErr++;
                return false;
            }

            maskInt = (maskInt << 8) + mask[i];
        }



        maskInt = (~maskInt) + 1;
        int test = 0x01;
        int flag = 0;

        for (int i = 0; i < 32; i++) {
            if (maskInt == test << i) {
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            ipErr--;
            return false;
        }

        // A类地址
        if (ip[0] >= 1 && ip[0] <= 126) {
            ipA ++;
            // 私有IP
            if (ip[0] == 10) {
                ipP++;
            }
        }
        // B类地址
        else if (ip[0] >= 128 && ip[0] <= 191) {
            ipB++;
            // 私有IP
            if (ip[0] == 127 && ip[1] > 16 && ip[1] <= 31) {
                ipP++;
            }
        }
        // C类地址
        else if (ip[0] >= 192 && ip[0] <= 223) {
            ipC++;
            if (ip[0] == 192 && ip[1] == 168) {
                ipP++;
            }
        }
        // D类地址
        else if (ip[0] >= 224 && ip[0] <= 239) {
            ipD++;
        }
        // E类地址
        else {
            ipE++;
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.next();
            int pos = input.indexOf('~');
            String ipStr = input.substring(0, pos);
            String maskStr = input.substring(pos +1);
            checkIp(ipStr, maskStr);
        }

        scanner.close();

        System.out.println(ipA + " " + ipB + " " + ipC + " " + ipD + " " + ipE + " " + ipErr + " " + ipP);

    }

}
