package com.glw;

import java.util.Arrays;
import java.util.List;

/**
 * @author glw
 * @date 2019/1/29 10:05
 * 2. Add Two Numbers
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 官方答案
    public static ListNode addTwoNumbersOffice(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, cur = result;
        int next = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = next + x + y;
            next = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (next > 0) {
            cur.next = new ListNode(next);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode nums1 = new ListNode(342);
        ListNode nums2 = new ListNode(465);
        ListNode result = addTwoNumbersOffice(nums1, nums2);
        System.out.println("我的答案：   数组1：" + nums1.toString() + " 数组2：" + nums2.toString() + "\n结果：" + result.toString());
    }
}
