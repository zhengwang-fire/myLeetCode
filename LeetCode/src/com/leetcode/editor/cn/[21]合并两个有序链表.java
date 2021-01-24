package com.leetcode.editor.cn;
//Java：合并两个有序链表
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1492 👎 0

import com.leetcode.editor.cn.utils.ListNode;

class P21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode();
        genericList(l1, 5, 10);
        ListNode l2 = new ListNode();
        genericList(l2, 5, 10);
        for (int i = 0; i < 6; i++) {
            System.out.print(l1.get(i).val + " ");
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(l2.get(i).val + " ");
        }
        System.out.println();
        ListNode total = solution.mergeTwoLists(l1, l2);
        for (int i = 0; total.get(i) != null; i++) {
            System.out.print(total.get(i).val + " ");
        }
    }

    public static void genericList(ListNode l1, int start, int end) {
        if (start >= end) {
            return;
        }
        l1.next = new ListNode(start++);
        genericList(l1.next, start, end);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode first = null;
            if (l1 == null) {
                if (l2 != null) {
                    first = l2;
                }
                return first;
            }
            if (l2 == null) {
                first = l1;
                return first;
            }
            first = new ListNode();
            if (l1.val > l2.val) {
                first.val = l2.val;
                setNext(first, l1, l2.next);
            } else {
                first.val = l1.val;
                setNext(first, l1.next, l2);
            }
            return first;
        }

        private void setNext(ListNode first, ListNode l1, ListNode l2) {
            ListNode next = new ListNode();
            if (l1 == null) {
                if (l2 != null) {
                    next = l2;
                    first.next = next;
                }
                return;
            }
            if (l2 == null) {
                next = l1;
                first.next = next;
                return;
            }
            if (l1.val > l2.val) {
                next.val = l2.val;
                setNext(next, l1, l2.next);
            } else {
                next.val = l1.val;
                setNext(next, l1.next, l2);
            }
            first.next = next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
