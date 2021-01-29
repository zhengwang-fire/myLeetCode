//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 459 👎 0

package com.leetcode.editor.cn;

import com.leetcode.editor.cn.utils.ListNode;

import java.util.Random;

class P83_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new P83_RemoveDuplicatesFromSortedList().new Solution();
        ListNode l1 = new ListNode();
        genericList(l1, 1, 10);
        for (int i = 0; i < 10; i++) {
            System.out.print(l1.get(i).val + " ");
        }
        System.out.println();
        ListNode result = solution.deleteDuplicates(l1);
        ListNode var1 = result;
        while (var1 != null) {
            System.out.print(var1.val + " ");
            var1 = var1.next;
        }
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
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode current = head;
            while (current != null && current.next != null) {
                if(current.val == current.next.val){
                    current.next = current.next.next;
                }else{
                    current = current.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}