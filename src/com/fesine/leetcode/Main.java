package com.fesine.leetcode;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a = 1024;
        //>>>无符号向右移位8位，即最高位补0
        int b = a >>> 8;
        //& 0xff=255=11111111 取低8位，&表示都是1取1，其他取0
        int c = a & 0xff;
        System.out.println(b);
        System.out.println(c);
    }
}
