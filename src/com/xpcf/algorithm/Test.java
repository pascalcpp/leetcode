package com.xpcf.algorithm;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author XPCF
 * @version 1.0
 * @date 3/31/2021 9:59 AM
 */
public class Test {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, InvocationTargetException {
        Constructor<Inst> declaredConstructor = Inst.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Inst =inst = declaredConstructor.newInstance();

    }


}
