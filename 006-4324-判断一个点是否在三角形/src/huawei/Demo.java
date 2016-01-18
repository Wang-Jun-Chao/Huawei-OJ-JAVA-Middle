package huawei;

public final class Demo {


    public static boolean isInTriangle(POINT A, POINT B, POINT C, POINT P) {
        // 点都没有问题
        if (checkPoint(A) && checkPoint(B) && checkPoint(C)) {
            double[] v0 = {C.x - A.x, C.y - A.y};
            double[] v1 = {B.x - A.x, B.y - A.y};
            double[] v2 = {P.x - A.x, P.y - A.y};

            double dot00 = v0[0] * v0[0] + v0[1] * v0[1];
            double dot01 = v0[0] * v1[0] + v0[1] * v1[1];
            double dot02 = v0[0] * v2[0] + v0[1] * v2[1];
            double dot11 = v1[0] * v1[0] + v1[1] * v1[1];
            double dot12 = v1[0] * v2[0] + v1[1] * v2[1];

            double inverDeno = 1 / (dot00 * dot11 - dot01 * dot01);
            double u = (dot11 * dot02 - dot01 * dot12) * inverDeno;

            if (u < 0 || u > 1) {
                return false;
            }

            double v = (dot00 * dot12 - dot01 * dot02) * inverDeno;
            if (v < 0 || v > 1) {
                return false;
            }

            return u + v <= 1;
        }

        return false;
    }

    private static boolean checkPoint(POINT point) {
        if (point == null) {
            return false;
        }

        return point.x >= 0 && point.x <= 99 && point.y >= 0 && point.y <= 99;
    }
}


