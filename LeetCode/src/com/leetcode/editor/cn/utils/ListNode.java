package com.leetcode.editor.cn.utils;

/**
 * 项目名称：  LeetCode
 * 类名称：  ListNode
 * 描述：
 * @author wangzheng
 * 创建时间：  2021/1/25 9:57
 * 修改人： wangzheng  修改日期： 2021/1/25 9:57
 * 修改备注：
 */
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

    public ListNode get(int i) {
        ListNode temp = this;
        for(int var1 = 0 ;var1 <=i ;var1++){
            temp = temp.next;
        }
        return temp;
    }
}