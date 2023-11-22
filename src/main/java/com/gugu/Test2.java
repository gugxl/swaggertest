package com.gugu;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(FindGreatestSumOfSubArray(arr));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {

        int res = array[0]; //记录当前所有子数组的和的最大值

        int max = array[0];   //包含array[i]的连续数组最大值

        for (int i = 1; i < array.length; i++) {

            max = Math.max(max + array[i], array[i]);

            res = Math.max(max, res);

        }

        return res;

    }


}
