package com.leetcode.editor.cn.utils;

import java.util.Random;

/**
 * 项目名称：  LeetCode
 * 类名称：  RandomArrUtil
 * 描述：
 * @author wangzheng
 * 创建时间：  2021/1/21 9:09
 * 修改人： wangzheng  修改日期： 2021/1/21 9:09
 * 修改备注：
 */
public class ArrUtil {
    public static int[] getRandomArr(int len, int range) {
        Random random = new Random();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = random.nextInt(range);
        }
        return nums;
    }

    public static void print(int[] nums) {
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}