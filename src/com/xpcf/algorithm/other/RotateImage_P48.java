package com.xpcf.algorithm.other;

/**
 * @author XPCF
 * @version 1.0
 * @date 6/1/2021 8:55 PM
 */
public class RotateImage_P48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l1 = n >> 1;
        int l2 = (n + 1) >> 1;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                int temp = matrix[i][j];
                // 4
                matrix[i][j] = matrix[n - j - 1][i];
                // 3
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                //2
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1] ;
                //1
                matrix[j][n - i - 1] = temp;
            }

        }

    }


}
