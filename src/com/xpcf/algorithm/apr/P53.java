package com.xpcf.algorithm.apr;

import java.util.Stack;

/**
 * @author XPCF
 * @version 1.0
 * @date 4/8/2021 12:00 PM
 */
public class P53 {

    class Status {
        int lSum;
        int rSum;
        int iSum;
        int mSum;

        public Status(int lSum, int rSum, int iSum, int mSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.iSum = iSum;
            this.mSum = mSum;
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }

        int mid = l + ((r - l) >> 1);
        return pushUp(getInfo(nums, l, mid), getInfo(nums, mid + 1, r));
    }

    public Status pushUp(Status lStatus, Status rStatus) {
        int iSum = lStatus.iSum + rStatus.iSum;
        int lSum = Math.max(lStatus.lSum, lStatus.iSum + rStatus.lSum);
        int rSum = Math.max(rStatus.rSum, rStatus.iSum + lStatus.rSum);
        int mSum = Math.max(Math.max(lStatus.mSum, rStatus.mSum), lStatus.rSum + rStatus.lSum);
        return new Status(lSum, rSum, iSum, mSum);
}

    public static void main(String[] args) {

    }

    

}
