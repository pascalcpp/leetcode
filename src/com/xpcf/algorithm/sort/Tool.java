package com.xpcf.algorithm.sort;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/7/2021 8:33 PM
 */
public class Tool {
    public interface Task {
        void exe();
    }

    public static void test(Task task) {
        task.exe();
    }
}
