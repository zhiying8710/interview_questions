package me.binge.questions;


/**
 * 输入一个表示整数的字符串，把该字符串转换成整数并输出。 例如输入字符串"345"，则输出整数345。
 *
 * @author Bingege
 *
 */
public class Q20 {

    public static int get(String s) {

        if (s == null || !s.matches("^[+-]?\\d*$")) {
            throw new IllegalArgumentException();
        }

        char[] cs = s.toCharArray();
        int i = 1; // 最后需要乘以这个数, 等到最终的值
        if ('-' == cs[0]) { // 说明是负数
            i = -1;
        }

        int r =  -1;
        for (char c : cs) {
            if ('+' == c || '-' == c) { // 第一个字符才会出现, 前面已做判断
                continue;
            }
            if (r == -1) { // 第一次运算
                r = Integer.valueOf(c + "");
            } else {
                r = r * 10 + Integer.valueOf(c + "");
            }
        }

        return r * i;

    }

    public static void main(String[] args) {

        System.out.println(get("1001"));
        System.out.println(get("-1001"));

    }


}
