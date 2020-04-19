package com.fesine.leetcode.twosum;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description: 从尾到头反过来打印出每个结点的值
 * @author: fesine
 * @createTime:2020/1/2
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/1/2
 */
public class PrintFromTailToHead {

    /**
     * 使用头插法
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        ListNode head = new ListNode(-1);
        while (listNode != null){
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next= listNode;
            listNode = memo;
        }
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    /**
     * 递归实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printFromTailToHead2(ListNode listNode){
        ArrayList<Integer> ret = new ArrayList<>();
        if(listNode !=null){
            ret.addAll(printFromTailToHead2(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     * 栈实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printFromTailToHead3(ListNode listNode){
        ArrayList<Integer> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode !=null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            ret.add(stack.pop());
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        //ArrayList<Integer> list = new PrintFromTailToHead().printFromTailToHead(listNode);
        //ArrayList<Integer> list = new PrintFromTailToHead().printFromTailToHead2(listNode);
        ArrayList<Integer> list = new PrintFromTailToHead().printFromTailToHead3(listNode);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static class ListNode{
       private Integer val;
       private ListNode next;

        public ListNode(Integer val) {
            this.val = val;
        }
    }

}
