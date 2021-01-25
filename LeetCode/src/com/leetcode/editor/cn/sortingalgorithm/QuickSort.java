package com.leetcode.editor.cn.sortingalgorithm;


import com.leetcode.editor.cn.utils.ArrUtil;

/**
 * 项目名称：  LeetCode
 * 类名称：  QuickSort
 * 描述：快速排序 难点在边界问题
 * @author wangzheng
 * 创建时间：  2021/1/22 10:58
 * 修改人： wangzheng  修改日期： 2021/1/22 10:58
 * 修改备注：
 */
public class QuickSort {

    public void sort(int[] nums, int low, int high) {
        if (low < high) {
            // 以最右边的点的值为基准点
            int key = nums[high];
            int i = low;
            // 已经以最后的值为基准点了 j的指针初始位置就是high-1
            int j = high - 1;
            // i<=j 的意思是 i和j可以重合位置
            while (i <= j) {
                //i<=j 的意思是 左右指针可以重合 避免 最大值在数组最后一位
                // 一直找 找到左边指针指向元素 大于基准元素的停止
                // nums[i] <= key  这个就是相等的时候 谁来管这个元素  左边忽略 继续走 让右边处理
                while (i <= j && nums[i] <= key) {
                    i++;
                }
                // i<=j 的意思是 左右指针可以重合 而且 可以 i-j =1 避免 最大值在数组第一位
                // 一直找 找到右边指针指向元素 小于基准元素的停止
                while (i <= j && nums[j] > key) {
                    j--;
                }
                // 上面循环停止了 就说明 左边一个大的 右边一个小的元素 这俩需要交换位置
                if (i < j) {
                    ArrUtil.swap(nums, i, j);
                }
            }
            ArrUtil.swap(nums, i, high);
            sort(nums, low, i - 1);
            sort(nums, i + 1, high);
        }
    }

    public static void main(String[] args) {
        QuickSort bubbleSort = new QuickSort();
        int len = 10;
        int[] nums = ArrUtil.getRandomArr(len, 10);
        ArrUtil.print(nums);
        System.out.println();
        bubbleSort.sort(nums, 0, nums.length - 1);
        ArrUtil.print(nums);
    }
}