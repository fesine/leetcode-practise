package com.fesine.leetcode.addtwonumbers;

/**
 * @description: 有两个单链表，代表两个非负数，每一个节点代表一个数位，数字是反向存储的，
 * 即第一个结点表示最低位，最后一个结点表示最高位。求两个数的相加和，并且以链表形式返回。
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author: Fesine
 * @createTime:2018/2/27
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2018/2/27
 */
public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //初始化结果值
        ListNode root = new ListNode(0);
        ListNode r = root;
        //两数相加和
        int sum;
        //进位
        int carry = 0;
        //初始化root的next节点
        root.next = l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            //本次处理结果
            p1.val = sum % 10;
            //本次进位
            carry = sum / 10;
            r.next=p1;
            r=p1;

            p1 = p1.next;
            p2 = p2.next;
        }
        //当其中一个节点数据遍历完成后
        if (p1 == null) {
            r.next = p2;
        } else {
            r.next=p1;
        }

        //最后处理carry=1的情况
        if (carry == 1) {
            while (r.next != null) {
                sum = r.next.val+carry;
                r.next.val = sum %10;
                carry = sum /10;
                r = r.next;
            }
            //最后carry还为1，则
            if(carry == 1){
                r.next = new ListNode(1);
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next=new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next=new ListNode(4);
        l2.next.next.next=new ListNode(1);

        ListNode node = addTwoNumbers(l1, l2);
        System.out.println();

    }
}
