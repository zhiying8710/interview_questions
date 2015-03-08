package me.binge.questions;


/**
 * n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始， 每次从这个圆圈中删除第m个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。
 * 当一个数字删除后，从被删除数字的下一个继续删除第m个数字。 求出在这个圆圈中剩下的最后一个数字。
 *
 * 类似报数问题.
 *
 * @author Bingege
 *
 */
public class Q18 {


    public static void get(int n, int m) {
        if (m < 1 || n < 2) {
            return;
        }
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }

        int k = 0; // 当前报数数
        int i = 0; // 下标
        int j = 0; // 删除的元素
        while (j < n - 1) { // 还有超过1个数字剩下的时候
            if (a[i] != -1) { // 如果不为-1, 表示没有被删除
                k ++;
            }
            if (k == m) {
                a[i] = -1; // 删除
                k = 0; // 初始化报数, 下次从1开始
                j ++; // 增加删除的元素
            }
            i ++; // 下标自增
            if (i == n) { // 超出数组长度, 从0开始.
                i = 0;
            }
        }
        for (int l : a) {
            if (l != -1) {
                System.out.println(l);
            }
        }

    }

    public static void main(String[] args) {
        get(100, 12);
    }





}
