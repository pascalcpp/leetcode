package com.xpcf.algorithm;


import com.xpcf.algorithm.util.SingleCircleLinkedList;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/31/2021 9:59 AM
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {

        SingleCircleLinkedList<Integer> list = new SingleCircleLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.reset();
        list.remove();
        System.out.println();
    }



}
