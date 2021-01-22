package com.leetcode.leetcode.editor.cn.sortingalgorithm;

import com.leetcode.leetcode.editor.cn.utils.ArrUtil;

/**
 * 项目名称：  LeetCode
 * 类名称：  BubbleSort
 * 描述：冒泡排序 稳定
 * 时间复杂度:O(n²)
 * 空间复杂度:O(1)
 * @author wangzheng
 * 创建时间：  2021/1/21 18:56
 * 修改人： wangzheng  修改日期： 2021/1/21 18:56
 * 修改备注：
 */
public class BubbleSort {

    /**
     * 方法名:  bubbleSort
     * 描述:  指针i指向的元素 和 指针j指向的元素比较 如果小就互换位置，
     * 然后i指针指向互换位置后的元素 与后面的元素继续比较 交换位置
     * 这样在i第一次循环就确定最小值
     * @author 王正
     * 创建时间: 2021/1/21 19:42
     * @param nums
     * @return void
     */
    public void sort(int[] nums) {
        int len = nums.length;
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    ArrUtil.swap(nums,i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int len = 100;
        int[] nums = ArrUtil.getRandomArr(len, 100);
        bubbleSort.sort(nums);
        ArrUtil.print(nums);
    }
}