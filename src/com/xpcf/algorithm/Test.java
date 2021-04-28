package com.xpcf.algorithm;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/31/2021 9:59 AM
 */
public class Test {


    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("asd", null);
        map.put(null, 1);
        System.out.println(map.get("asd"));
    }


}
