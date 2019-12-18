package com.fesine.leetcode.duplicate;

/**
 * @description: 在一个长度为 n 的数组里的所有数字都在 0 到 n-1
 * 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 *
 * 要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 *
 * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。本题要求找出重复的数字，
 * 因此在调整过程中，如果第 i 位置上已经有一个值为 i
 * 的元素，就可以知道 i 值重复。
 *
 * 以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，
 * 但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复：
 * @author: fesine
 * @createTime:2019/12/18
 * @update:修改内容
 * @author: fesine
 * @updateTime:2019/12/18
 */
public class DuplicateNum {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if(numbers == null || length <=0){
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers,i,numbers[i]);
            }
        }
        return false;
    }

    /**
     * 交换数组中的两个位置上的数
     * @param numbers
     * @param i
     * @param j
     */
    private void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5};
        int[] duplication = new int[1];
        DuplicateNum duplicateNum = new DuplicateNum();
        if (duplicateNum.duplicate(numbers, numbers.length, duplication)) {
            System.out.println(duplication[0]);
        }
    }

}
