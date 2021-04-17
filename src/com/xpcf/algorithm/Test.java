package com.xpcf.algorithm;


import com.xpcf.algorithm.util.SingleCircleLinkedList;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/31/2021 9:59 AM
 */
public class Test {


    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        String s1 = new String("abcd");
        String s2 = new String("abcd");
        System.out.println(s1.hashCode() + "           " + s2.hashCode());
        System.out.println(s1 == s2);
    }


}
