package com.leetcode.editor.cn;
//Java：两数相加
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5530 👎 0

import com.leetcode.editor.cn.utils.ListNode;
import com.leetcode.editor.cn.utils.RandomArrUtil;

import java.util.LinkedList;
import java.util.Random;

class P2AddTwoNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        Solution solution = new P2AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(9);
        genericList(l1, 10);
        ListNode l2 = new ListNode(9);
        genericList(l2, 5);
        for (int i = 0; i < 10; i++) {
            System.out.print(l1.get(i).val + " ");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(l2.get(i).val + " ");
        }
        System.out.println();
        ListNode total = solution.addTwoNumbers(l1, l2);
        for (int i = 0; total.get(i) != null; i++) {
            System.out.print(total.get(i).val + " ");
        }
    }

    public static void genericList(ListNode l1, int len) {
        if (len == 1) {
            return;
        }
        Random random = new Random();
        int aa = random.nextInt(10);
        while (aa == 0) {
            aa = random.nextInt(10);
        }
        l1.next = new ListNode(9);
        len--;
        genericList(l1.next, len);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode total = new ListNode();
            aa(l1, l2, total);
            return total;
        }

        public void aa(ListNode l1, ListNode l2, ListNode total) {

            l1 = l1 == null ? new ListNode(0) : l1;
            l2 = l2 == null ? new ListNode(0) : l2;
            int value = l1.val + l2.val;
            ListNode next = new ListNode(0);
            if (value >= 10 || (value == 9 && total.val == 1)) {
                total.val += (value - 10);
                next.val = 1;
            } else {
                total.val += value;
            }
            if(l1.next == null && l2.next == null){
                if(next.val == 1){
                    total.next = next;
                }
                return;
            }
            total.next = next;
            aa(l1.next, l2.next, total.next);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}


