package com.leetcode.editor.cn.sortingalgorithm;


import com.leetcode.editor.cn.utils.ArrUtil;

/**
 * 项目名称：  LeetCode
 * 类名称：  ShellSort
 * 描述：希尔排序
 * @author wangzheng
 * 创建时间：  2021/1/21 20:36
 * 修改人： wangzheng  修改日期： 2021/1/21 20:36
 * 修改备注：
 */
public class ShellSort {

    /**
     * 方法名:  sort
     * 描述: 对插入排序的一种升级  插入排序每次只能移动一个单位，
     * @param nums
     * @return void
     * @author 王正
     * 创建时间: 2021/1/21 20:40
     */
    public void sort(int[] nums) {
        int gap = 1;
        //此处是求最佳初始步长 （Knuth步长）
        while (gap <= nums.length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < nums.length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (nums[j] < nums[j - gap]) {
                        ArrUtil.swap(nums, j, j - gap);
                    }
                }
            }
            gap = (gap - 1) / 3;
        }
    }

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int len = 10;
        int[] nums = ArrUtil.getRandomArr(len, 20);
        ArrUtil.print(nums);
        System.out.println();
        sort.sort(nums);
        ArrUtil.print(nums);
    }
}