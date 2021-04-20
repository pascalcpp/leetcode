package com.xpcf.algorithm;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/19/2021 11:07 PM
 */
public enum Inst {

    INSTANCE;
    private Inst() {
        System.out.println("construct");
    }
}
