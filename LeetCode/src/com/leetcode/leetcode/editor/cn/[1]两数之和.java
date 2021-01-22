//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10094 👎 0

package com.leetcode.leetcode.editor.cn;

import com.leetcode.leetcode.editor.cn.utils.ArrUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class TwoSum {
    public static void main(String[] args) {
        for(int i = 0;i<100;i++){
            verification(i);
        }
    }

    public static void verification(int k) {
        int len = 1000;
        int[] nums  = ArrUtil.getRandomArr(len,10000);
        Random random = new Random();
        int first = random.nextInt(len);
        int second = random.nextInt(len);
        int target = 0;
        target+=nums[first];
        target+=nums[second];
        Solution solution = new TwoSum().new Solution();
        System.out.println("target  is ------>"+ target);
        int result [] = solution.twoSum(nums, target);
        System.out.println("result is " + nums[result[0]] + "," +nums[result[1]]);
        assert result[0] == nums[first];
        assert result[1] == nums[second];
        k++;
        System.out.println("随机测试结果正确" + k);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hashTable = new HashMap<>((int) (nums.length * 1.7 + 1));
            for (int i = 0; i < nums.length; i++) {
                if (hashTable.containsKey(target - nums[i])) {
                    return new int[]{hashTable.get(target - nums[i]), i};
                }
                hashTable.put(nums[i], i);
            }
            return new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}