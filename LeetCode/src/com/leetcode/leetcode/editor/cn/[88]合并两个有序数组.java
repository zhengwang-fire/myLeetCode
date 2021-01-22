package com.leetcode.leetcode.editor.cn;
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 739 👎 0

import com.leetcode.leetcode.editor.cn.sortingalgorithm.QuickSort;
import com.leetcode.leetcode.editor.cn.utils.ArrUtil;

import java.util.logging.Level;

class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = ArrUtil.getRandomArr(10, 10);
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums1, 0, nums1.length - 1);
        for (int i = 5; i < 10; i++) {
            nums1[i] = 0;
        }
        ArrUtil.print(nums1);
        System.out.println();
        int[] nums2 = ArrUtil.getRandomArr(5, 10);
        quickSort.sort(nums2, 0, nums2.length - 1);
        ArrUtil.print(nums2);
        System.out.println();
        solution.merge(nums1, 5, nums2, 5);
        ArrUtil.print(nums1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int p = m + n - 1;
            while ((p1 >= 0) && (p2 >= 0)){
                nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
            }
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}