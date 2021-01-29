//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 88 👎 0

package com.leetcode.editor.cn;

import com.leetcode.editor.cn.utils.ArrUtil;
import com.leetcode.editor.cn.utils.ListNode;

import java.util.Random;

class P剑指Offer06_CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer06_CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
        ListNode l1 = new ListNode();
        genericList(l1, 1, 10);
        for (int i = 0; i < 10; i++) {
            System.out.print(l1.get(i).val + " ");
        }
        System.out.println();
        int[] result = solution.reversePrint(l1);
        ArrUtil.print(result);
    }

    public static void genericList(ListNode l1, int start, int end) {
        Random random = new Random();
        l1.val = random.nextInt(10);
        if (start == end) {
            return;
        }
        ListNode next = new ListNode();
        l1.next = next;
        start++;
        genericList(next, start, end);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            ListNode prev = new ListNode(-1, head);
            ListNode cur = prev;
            ListNode pre = null;
            ListNode next;
            int count = 0;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                count++;
            }
            int[] result = new int[count - 1];
            for (int i = 0; pre.next != null; i++) {
                result[i] = pre.val;
                pre = pre.next;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}