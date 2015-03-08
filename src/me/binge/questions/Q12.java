package me.binge.questions;

/**
 * 题目：求1+2+…+n， 要求不能使用乘除法、for、while、if、else、switch、case等关键字以及条件判断语句（A?B:C）。
 *
 *
 *<br/>
 *
 * 使用递归和&&的短路
 * @author Bingege
 *
 */
public class Q12 {

    @SuppressWarnings("unused")
    public static int sum(int n, int sum) {

        boolean _ = (n != 0) && ((sum = sum(n - 1, sum)) > 0);

        return n + sum;
    }

    public static void main(String[] args) {

        System.out.println(sum(100, 0));

    }

}
