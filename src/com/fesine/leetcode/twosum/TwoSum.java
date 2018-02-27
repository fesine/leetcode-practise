package com.fesine.leetcode.twosum;

import java.util.Arrays;

/**
 * @description: 确定一个数组中有两个值，相加的值等目标值，找出两个值在数组中的位置，起始位置从1开始计数
 * 比如{1,3,8,4,5} 目标值7，值为3+4，两个元素位置分别是2和4，返回结果{2,4}
 * @author: Fesine
 * @createTime:2018/2/27
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2018/2/27
 */
public class TwoSum {

    private static class Node implements Comparable<Node>{

        /**
         * 数组节点值
         */
        private int val;
        /**
         * 数组节点索引值
         */
        private int idx;

        private Node(){}

        public Node(int val,int idx){
            this.val=val;
            this.idx=idx;
        }

        @Override
        public int compareTo(Node o) {
            if (o == null) {
                return -1;
            }
            return this.val-o.val;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result={0,0};
        //获取数组长度
        int length = nums.length;
        //构建Node节点数组
        Node[] nodes = new Node[length];
        for (int i = 0; i < length; i++) {
            nodes[i] = new Node(nums[i],i);
        }

        //排序
        Arrays.sort(nodes);
        int loIdx = 0;
        int hiIdx = length-1;
        while (loIdx<hiIdx){
            if (nodes[loIdx].val + nodes[hiIdx].val == target) {
                if (nodes[loIdx].idx > nodes[hiIdx].idx) {
                    result[0] = nodes[hiIdx].idx + 1;
                    result[1] = nodes[loIdx].idx + 1;
                } else {
                    result[0] = nodes[loIdx].idx + 1;
                    result[1] = nodes[hiIdx].idx + 1;
                }
                break;
            } else if (nodes[loIdx].val + nodes[hiIdx].val < target) {
                loIdx++;
            } else {
                hiIdx--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] nums = {1, 3, 8, 4, 5};
        int [] result = TwoSum.twoSum(nums,7);
        System.out.println("result:["+result[0]+","+result[1]+"]");
    }
}
