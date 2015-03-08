package me.binge.questions;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

/**
 * 给你10分钟时间，根据上排给出十个数，在其下排填出对应的十个数 要求下排每个数都是先前上排那十个数在下排出现的次数。
 * 上排的十个数如下：【0，1，2，3，4，5，6，7，8，9】
 *
 * 举个例子， 上排数值: 0,1,2,3,4,5,6,7,8,9 下排数值: 6,2,1,0,0,0,1,0,0,0
 * 0在下排出现了6次，1在下排出现了2次， 2在下排出现了1次，3在下排出现了0次....
 * =======
 *
 * 先随机初始化下排数组, 最简单办法, 复制一份上排数组
 *
 * 然后迭代上排数组, 每个元素到下排数组中去比较, 得出在下排数组中出现的次数, 如果得出的次数与下排数组中对应的位置的值不同, 则替换, 无限次迭代, 直到下排数组中得值全部正确
 * @author Bingege
 *
 */
public class Q6 {

    public static int[] get(int[] a) {

        int[] b = Arrays.copyOf(a, a.length);

        boolean succ = false;
        int i = 0;
        while (!succ) {
            i ++;
            succ = setNextB(a, b);
            System.out.println("====: " + StringUtils.join(b, ','));
        }
        System.err.println(i);
        return b;
    }

    private static boolean setNextB(int[] a, int[] b) {

        boolean r = true;

        for (int i = 0; i < a.length; i++) {
            int cnt = 0;
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    cnt += 1;
                }
            }
            if (cnt != b[i]) {
                b[i] = cnt;
                r = false;
            }
        }

        return r;

    }

    public static void main(String[] args) {
        System.out.println(StringUtils.join(get(new int[]{0,1,2,3,4,5,6,7,8,9,10, 100}), ','));
//        System.out.println(StringUtils.join(get(new int[]{9,5,7,2,7,1,5,8}), ','));
        //System.out.println(StringUtils.join(get(new int[]{10,21,32,43,54,65,76,87,98,109,1110}), ','));
    }


}
