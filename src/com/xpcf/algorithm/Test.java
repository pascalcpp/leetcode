package com.xpcf.algorithm;


import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/31/2021 9:59 AM
 */
public class Test {


    @Override
    protected void finalize() throws Throwable {
        System.out.println("gc");
    }

    public static void main(String[] args) throws InterruptedException {

        List<Test> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Test());
        }

        list.clear();
        System.gc();
        TimeUnit.SECONDS.sleep(10);
    }



}
