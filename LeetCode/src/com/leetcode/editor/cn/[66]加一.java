package com.leetcode.leetcode.editor.cn;
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 616 👎 0

import com.leetcode.leetcode.editor.cn.utils.ArrUtil;

class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        int[] digits = {9,1};
        int [] reuslt = solution.plusOne(digits);
        ArrUtil.print(reuslt);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            if (digits[0] == 9) {
                int[] newDigits = new int[digits.length + 1];
                System.arraycopy(digits, 0, newDigits, 1, digits.length);
                addOne(newDigits, newDigits.length - 1);
                if(newDigits[0] == 0){
                    int[] newD = new int[newDigits.length-1];
                    System.arraycopy(newDigits, 1, newD, 0, newD.length);
                    return newD;
                }
                return newDigits;
            } else {
                addOne(digits, digits.length - 1);
            }
            return digits;
        }

        public void addOne(int[] digits, int digit) {
            if (digit < -1) {
                return;
            }
            if (digits[digit] + 1 < 10) {
                digits[digit] = digits[digit] + 1;
            } else {
                digits[digit] = 0;
                addOne(digits, --digit);
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}