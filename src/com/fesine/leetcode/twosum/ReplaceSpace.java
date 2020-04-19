package com.fesine.leetcode.twosum;

/**
 * @description: 将一个字符串中的空格替换成 "%20"
 * @author: fesine
 * @createTime:2020/1/2
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/1/2
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str){
        int p1= str.length()-1;
        for (int i = 0; i < p1; i++) {
            if(str.charAt(i) == ' '){
                str.append("  ");
            }
        }
        int p2 = str.length()-1;
        while (p1 > 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if(c == ' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else{
                str.setCharAt(p2--,c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = new ReplaceSpace().replaceSpace(new StringBuffer("A   B C"));
        System.out.println(str);
    }
}
