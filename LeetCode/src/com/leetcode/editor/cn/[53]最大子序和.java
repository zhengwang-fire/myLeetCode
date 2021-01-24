package com.leetcode.editor.cn;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2812 👎 0

class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(solution.maxSubArray(nums));
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(nums));
    }

    class Status {
        private int lSum, rSum, mSub, iSub;

        public Status(int l, int r, int mSub, int iSub) {
            this.lSum = l;
            this.rSum = r;
            this.mSub = mSub;
            this.iSub = iSub;
        }

        public Status(Status l, Status r) {
            // 区间和 左右子区间的区间和相加
            this.iSub = l.iSub + r.iSub;
            // 存在两种可能，
            // 它要么等于「左子区间」的 lSum，
            // 要么等于「左子区间」的 iSum 加上「右子区间」的 lSum，二者取大。
            this.lSum = Math.max(l.iSub + r.lSum, l.lSum);
            // 存在两种可能，
            // 它要么等于「右子区间」的 rSum，
            // 要么等于「右子区间」的 iSum 加上「左子区间」的 rSum，二者取大。
            this.rSum = Math.max(r.iSub + l.rSum, r.rSum);
            // 存在三种可能，
            // 它要么等于「右子区间」的 mSub，
            // 要么等于「左子区间」的 mSub,
            // 要么等于左子区间的rSum + 「右子区间」的lSum 取最大值 (其实就是左右子区间相邻部分 的中间区间)
            this.mSub = Math.max(Math.max(l.mSub, r.mSub), l.rSum + r.lSum);
        }
    }

    public int maxSubArray(int[] nums) {
        return divideAndRule(nums, 0, nums.length - 1).mSub;
    }

    public Status divideAndRule(int[] nums, int L, int R) {
        if (L == R) {
            return new Status(nums[L], nums[L], nums[L], nums[L]);
        }
        int mid = L + ((R - L) >> 1);
        // 求出左右节点
        Status l = divideAndRule(nums, L, mid);
        Status r = divideAndRule(nums, mid + 1, R);
        return new Status(l, r);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0;
            // 防止第一个就是最大
            int total = nums[0];
            for (int n : nums) {
                // 判断如果加了之后变小了 就从这个值开始算 之前的抛弃
                pre = Math.max(pre + n, n);
                // 将最大值记录下来 每次比较下
                total = Math.max(total, pre);
            }
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}