package me.binge.questions;

import org.apache.commons.lang3.StringUtils;

/**
 * 输入一个已经按升序排序过的数组和一个数字， 在数组中查找两个数，使得它们的和正好是输入的那个数字。
 * 要求时间复杂度是O(n)。如果有多对数字的和等于输入的数字，输出任意一对即可。
 * 例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 *
 * @author Bingege
 *
 */
public class Q14 {

    public static int[] get(int[] a, int n) {

        int begin = 0;
        int end = a.length - 1;
        while (begin < end) {

            int currSum = a[begin] + a[end];
            if (currSum > n) { // 如果求的和大于期望值, 说明第二个数大了
                end --;
            } else if (currSum < n) { // 如果求的和小于期望值, 说明第一个数小了
                begin ++;
            } else {
                return new int[]{a[begin], a[end]};
            }

        }

        return null;
    }

    public static void main(String[] args) {

        int[] a = new int[]{1,2,4,7,11,15};
        System.out.println(StringUtils.join(get(a, 15), ','));

    }

}
