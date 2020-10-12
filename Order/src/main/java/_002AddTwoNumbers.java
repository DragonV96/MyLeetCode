import constant.Constant;

import java.util.Arrays;
import java.util.LinkedList;

/**
@author : glw
@date : 2020/10/12
@time : 9:05
@Description :
2. 两数相加
 */
public class _002AddTwoNumbers {

    /**
     * 递归思路
     * ①把当前 node 的 val 赋值为 l1.val + l2.val + carry ，其中 carry 为逢十进一的值
     * ②把上一个 lastNode 的 next 赋值为当前 node
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = null;
        sentinel = new ListNode(0);
        int carry = 0;
        ListNode node = sentinel;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int temp = val1 + val2 + carry;
            if (node == null) {
                node = new ListNode(temp % 10);
            } else {
                node.next = new ListNode(temp % 10);
                node = node.next;
            }
            carry = temp > 9 ? 1 : 0;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            node.next = new ListNode(carry);
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode num1Ge = new ListNode(9);
        ListNode num1shi = new ListNode(9, num1Ge);
        ListNode num1bai = new ListNode(9, num1shi);
        ListNode num1qian = new ListNode(9, num1bai);
        ListNode num1 = new ListNode(9, num1qian);

        ListNode num2Ge = new ListNode(9);
        ListNode num2shi = new ListNode(9, num2Ge);
        ListNode num2 = new ListNode(9, num2shi);


        System.out.print(Constant.MY_ANSWER);
        ListNode listNode = addTwoNumbers(num1, num2);
        System.out.println(listNode);
        System.out.print(Constant.MY_ANSWER);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
