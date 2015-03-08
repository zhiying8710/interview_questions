package me.binge.questions;


/**
 * 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
 *
 * 如果从头遍历，与后面字符进行比较出现次数是否为1，算法复杂度为O(n^2)，
 * 考虑以空间换时间，因为一个字符占8位。因此可用一个256位数组保存每个字符出现的次数
 * @author Bingege
 *
 */
public class Q17 {

    /**
     * 一个 linkedHashMap 就可以搞定
     * @param s
     */
    public static void get(String s) {

        int[] cnts = new int[256];
        char[] scs = s.toCharArray();
        for (char c : scs) {
            int idx = c;
            cnts[idx] = cnts[idx] + 1;
        }

        for (char c : scs) {
            int idx = c;
            if (cnts[idx] == 1) { //找到第一个唯一出现一次的字符了
                System.out.println("it is " + c);
                return;
            }
        }

        System.out.println("not found.");
    }

    public static void main(String[] args) {

        get("aacbdd");

    }


}
