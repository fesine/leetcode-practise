package com.fesine.leetcode.twosum;

/**
 * @description: 题目描述
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * <p>
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 * 解题思路
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 * <p>
 * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，
 * 就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
 * @author: fesine
 * @createTime:2019/12/18
 * @update:修改内容
 * @author: fesine
 * @updateTime:2019/12/18
 */
public class FindNumInArrays {

    public boolean find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        //获取行数和列数
        int rows = array.length;
        int cols = array[0].length;
        //从右上角开始比对
        int r = 0, c = cols - 1;
        while (r <= rows - 1 && c >= 0) {
            if (target == array[r][c]) {
                return true;
            } else if (target > array[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindNumInArrays main = new FindNumInArrays();
        int[][] array = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 23;
        System.out.println(main.find(target, array) ? target + ":在数组中" : target + ":不在数组中");
    }
}
