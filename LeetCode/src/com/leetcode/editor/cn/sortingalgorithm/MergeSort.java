package com.leetcode.editor.cn.sortingalgorithm;


import com.leetcode.editor.cn.utils.ArrUtil;

/**
 * 项目名称：  LeetCode
 * 类名称：  MergeSort
 * 描述：归并排序
 * @author wangzheng
 * 创建时间：  2021/1/22 9:56
 * 修改人： wangzheng  修改日期： 2021/1/22 9:56
 * 修改备注：
 */
public class MergeSort {
    public void sort(int[] nums) {
        int[] newNums = mergeSort(nums, 0, nums.length - 1);
        System.arraycopy(newNums, 0, nums, 0, newNums.length);
    }

    private int[] mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return new int[]{nums[left]};
        }
        int mid = left + ((right - left) >> 1);
        int[] leftNums = mergeSort(nums, left, mid);
        int[] rightNums = mergeSort(nums, mid + 1, right);
        int[] newNums = new int[leftNums.length + rightNums.length];
        int i = 0;
        int j = 0;
        int m = 0;
        while (i < leftNums.length && j < rightNums.length) {
            newNums[m++] = leftNums[i] > rightNums[j] ? rightNums[j++] : leftNums[i++];
        }
        //当全部比较完了 就要判断哪边还有剩余没有比较的
        while (i < leftNums.length) {
            newNums[m++] = leftNums[i++];
        }
        while (j < rightNums.length) {
            newNums[m++] = rightNums[j++];
        }
        return newNums;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int len = 10;
        int[] nums = ArrUtil.getRandomArr(len, 20);
        ArrUtil.print(nums);
        System.out.println();
        sort.sort(nums);
        ArrUtil.print(nums);
    }
}