package com.leetcode.editor.cn.utils;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode get(int var1) {
        ListNode var2 = this;
        for (int i = 0; i < var1; ++i) {
            var2 = var2.next;
        }
        return var2;
    }

    private ListNode getNext() {
        ListNode var2 = this;
        var2 = var2.next;
        return var2;
    }
}