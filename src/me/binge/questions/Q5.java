package me.binge.questions;

import org.apache.commons.lang3.StringUtils;


/**
 * 输入 n 个整数, 输出其中最小的 k 个
 * 取原数组中得 k 个元素组成一个数组, 这个新数组用最大堆结构进行存储(即其中的最大值在第一个),
 * 迭代原数组中剩下的元素, 与最大堆比较, 如果要小于最大堆中得最大值, 则替换并重新生成最大堆(用时 logk)
 * 最后最大堆中存在的就是最小的 k个数, 时间复杂度O（n*logk)
 *
 * 另一种方式, 取原数组中得 k 个元素组成一个数组, 对新数组进行排序, 然后迭代剩下的元素, 如果大于新数组中的最大值, 则替换并重新排序(用时O(k))
 * 最后这个新数组里的元素即为最小的 k 个数, 时间复杂度 O(k * n)
 * @author Bingege
 *
 */
public class Q5 {

    public static int[] get(int[] a, int k) {
        if (k > a.length) {
            return null;
        }
        if (k == a.length) {
            return a;
        }
        int[] ka = new int[k];
        for (int i = 0; i < k; i++) {
            ka[i] = a[i];
        }
        buildHead(ka);
        for (int i = k; i < a.length; i++) {
            if (a[i] < ka[0]) {
                ka[0] = a[i];
                maxHeadp(ka, 1, k);
            }
        }
        return ka;
    }

    private static void buildHead(int[] ka) {

        int heapSize = ka.length;
        for (int i = ka.length / 2; i > 0; i--) {
            maxHeadp(ka, i, heapSize);
        }

    }

    private static void maxHeadp(int[] ka, int i, int heapSize) {

        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= heapSize && ka[left - 1] > ka[i - 1]) {
            largest = left;
        }
        if (right <= heapSize && ka[right - 1] > ka[largest - 1]) {
            largest = right;
        }
        if (largest != i) {
            int temp = ka[i - 1];
            ka[i - 1] = ka[largest -1];
            ka[largest - 1] = temp;
            System.out.println("===: " + StringUtils.join(ka, ','));
            maxHeadp(ka, largest, heapSize);
        }

    }
    public static void main(String[] args) {

        int[] ka = new int[]{3,1,4,0,5,9};
        buildHead(ka);
        System.out.println(StringUtils.join(ka, ','));

    }



}
