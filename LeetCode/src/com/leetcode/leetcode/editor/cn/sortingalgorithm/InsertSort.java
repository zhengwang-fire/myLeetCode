package com.leetcode.leetcode.editor.cn.sortingalgorithm;

import com.leetcode.leetcode.editor.cn.utils.ArrUtil;

/**
 * 项目名称：  LeetCode
 * 类名称：  InsertSort
 * 描述：
 * @author wangzheng
 * 创建时间：  2021/1/21 19:24
 * 修改人： wangzheng  修改日期： 2021/1/21 19:24
 * 修改备注：
 */
public class InsertSort {
    /**
     * 方法名:  insertSort
     * 描述: 后一个值和前一个相比较 如果小于 就互换位置，然后下次循环再次从头开始两两比较
     * @param nums
     * @return void
     * @author 王正
     * 创建时间: 2021/1/21 19:46
     */
    public void sort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    ArrUtil.swap(nums, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertSort bubbleSort = new InsertSort();
        int len = 10;
        int[] nums = ArrUtil.getRandomArr(len, 100);
        bubbleSort.sort(nums);
        ArrUtil.print(nums);
    }
}