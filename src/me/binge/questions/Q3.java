package me.binge.questions;

/**
 * 求一个数组中连续元素组成的子数组的最大和
 */
public class Q3 {

    /**
     * 遍历数组, 元素顺序相加, 当得出的和 b 小于0时, 将 b 设为 a[i].
     * 如果 b 大于 sum, 则将 b 赋予 sum.
     * 例如: [1,-8,6,3,-1,5,7,-2,0,1]
     * 1 + -8 < 0, 则 b = 6,  此时 b > sum, 所以sum = 6;
     * 6 + 3 = b > sum, 所以 sum = 9
     * 9 + -1 = 8 = b < sum, 所以 sum 不变
     * 8 + 5 + 7 = 20 > sum, 所以 sum = 20
     * 20 + -2 + 0 + 1 = 19 < sum, 所以 sum 不变
     * 最后得出 sum = 20
     *
     * @param a
     */
    public static void maxSum(int[] a) {

        int tmp = a[0];
        for (int i = 1; i < a.length; i++) {
            if (tmp < a[i]) {
                tmp = a[i];
            }
        }
        if (tmp < 0) {
            System.out.println("max sum: " + tmp);
            return;
        }

        int b = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (b < 0) {
                b = a[i];
            } else {
                b += a[i];
            }

            if (b >= sum) {
                sum = b;
            }
        }
        System.out.println("max sum: " + sum);

    }

    public static void main(String[] args) {

        maxSum(new int[] {1,-8,6,3,-1,5,7,-2,0,1});
    }

}
