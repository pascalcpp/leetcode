package com.xpcf.algorithm;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/29/2021 5:12 AM
 */
public class P69 {

    public static void main(String[] args) {
        P69 p69 = new P69();
        p69.mySqrt2(1);
    }

    public int mySqrt(int x) {
        int l = 0, r = x;
        int mid = x;

        while (l <= r) {
//            == x 时 因为 x.5会取左边的数 所以 l = mid + 1
            if ((long) mid * mid <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            mid = l + ((r - l) >> 1);
        }

        return mid;
    }


    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        double precision = 1e-6;
        double x0 = x, x1;
        while (true) {
            x1 = 0.5 * (x0 + x / x0);
            if (x0 - x1 < precision) {
                break;
            }
            x0 = x1;
        }
        return (int) x1;
    }



}
