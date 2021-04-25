package com.xpcf.algorithm;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/31/2021 9:59 AM
 */
public class Test {

    static class Father {
        int x = 10;

        public Father() {
            this.print();
            x = 20;
        }
        public void print() {
            System.out.println("Father.x = " + x);
        }
        public int getX() {
            return x;
        }
    }

    static class Son extends Father {

        @Override
        public int getX() {
            return x;
        }
        int x = 30;
        //    float x = 30.1F;
        public Son() {
            this.print();
            x = 40;
        }
        @Override
        public void print() {
            System.out.println("Son.x = " + x);
        }
    }

    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.x);
        System.out.println(f.getX());
    }



}
