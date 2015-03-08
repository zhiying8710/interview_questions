package me.binge.questions;

/**
 * 定义 Fibonacci 数列如下：
 * / 0 n=0
 * f(n)= 1 n=1,2
 * \ f(n-1)+f(n-2) n>2
 * 输入 n，用最快的方法求该数列的第 n 项。
 * @author Bingege
 *
 */
public class Q19 {

    static int c = 0;

    /**
     * 递归
     * @param n
     * @return
     */
    public static long fibonacci(long n) {
        c ++;
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    /**
     * 递推
     * @param n
     * @return
     */
    public static long fibonacci2(long n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int one = 1;
        int two = 1;
        int t = 0;
        for (int i = 3; i <= n; i++) {
            t = one + two;
            one = two;
            two = t;
        }

        return t;

    }


    public static void main(String[] args) {
//        System.out.println(fibonacci(100));
        System.out.println(fibonacci2(50));
    }


}
