//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
// 示例 1:
//
//
//输入: [1,2,3]
//输出: 6
//
//
// 示例 2:
//
//
//输入: [1,2,3,4]
//输出: 24
//
//
// 注意:
//
//
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
//
// Related Topics 数组 数学
// 👍 223 👎 0

package com.leetcode.editor.cn;

class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfThreeNumbers().new Solution();
        int[] nums = new int[]{7, 3, 1, 0, 0, 6};
        //        solution.maximumProduct(nums);
        System.out.println(solution.maximumProduct(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumProduct(int[] nums) {
            sort(nums, 0, nums.length - 1);
            return Math.max(nums[0] * nums[1] * nums[2], nums[nums.length - 1] * nums[nums.length - 2] * nums[0]);
        }

        private int[] sort(int[] nums, int start, int end) {
            int pivot = nums[start];
            int left = start;
            int right = end;
            while (left < right) {
                while (left < right && nums[left] > pivot) {
                    left++;
                }
                while (left < right && nums[right] < pivot) {
                    right--;
                }
                if (nums[left] == nums[right] && left < right) {
                    left++;
                } else {
                    swap(nums, left, right);
                }
            }
            if (start < left - 1) {
                sort(nums, start, left - 1);
            }
            if (left + 1 < end) {
                sort(nums, left + 1, end);
            }
            return nums;
        }

        void print(int[] nums) {
            for (int n : nums) {
                System.out.print(n + " ");
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}