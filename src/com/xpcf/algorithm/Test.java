package com.xpcf.algorithm;

import com.sun.deploy.util.ArrayUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/31/2021 9:59 AM
 */
public class Test {


    public static void main(String[] args) {

        InputStream in = System.in;
        System.out.println();


    }

    static List<String> list = new ArrayList<String>();

    static void cha_62(int n) {
        if (n >= 62) {
            cha_62(n / 62);
        }
        list.add("[" + n % 62 + "]");
    }


}
