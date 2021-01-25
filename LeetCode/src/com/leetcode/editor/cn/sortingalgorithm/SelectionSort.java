package com.leetcode.leetcode.editor.cn.sortingalgorithm;

import com.leetcode.leetcode.editor.cn.utils.ArrUtil;

/**
 * 项目名称：  LeetCode
 * 类名称：  SelectionSort
 * 描述：选择排序 直观 不稳定的排序方法
 * 时间复杂度:O(n²)
 * 空间复杂度:O(1)
 * @author wangzheng
 * 创建时间：  2021/1/21 18:31
 * 修改人： wangzheng  修改日期： 2021/1/21 18:31
 * 修改备注：
 */
public class SelectionSort {

    /**
     * 方法名:  sort
     * 描述: 用i指针 指定一个位置的数，循环和i后面的数比较出最小的数
     * 用k记录最小值；将最小值放到当前i位置
     * @param nums
     * @param flag
     * @return void
     * @author 王正
     * 创建时间: 2021/1/21 18:54
     */
    public void sort(int[] nums) {
        int len = nums.length;
        int k;
        for (int i = 0; i < len; i++) {
            k = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            ArrUtil.swap(nums,i,k);
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int len = 10;
        int[] nums = ArrUtil.getRandomArr(len, 20);
        ArrUtil.print(nums);
        System.out.println();
        selectionSort.sort(nums);
        ArrUtil.print(nums);
    }

}