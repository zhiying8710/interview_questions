package me.binge.questions;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 判断整数序列是不是二元查找树的后序遍历结果 题目：输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。 如果是返回 true，否则返回
 * false。 例如输入5、7、6、9、11、10、8，由于这一整数序列是如下树的后序遍历结果：
 *  	8
 * 	   / \
 * 	   6 10
 *    / \ / \
 *    5 7 9 11
 * 因此返回 true。 如果输入7、4、6、5，没有哪棵树的后序遍历的结果是这个序列，因此返回 false。
 * =====
 * 首先要直到什么是二元查找树, 二元查找树中左子树的所有节点的值都小于根节点的值, 右子树的 所有节点的值都小于根节点的值
 * @author Bingege
 *
 */
public class Q9 {

    public static boolean get(int [] a, int len) {
        System.out.println(len);
        //确定根节点
        int root = a[len - 1];

        // 确定左右子树边界
        int i = 0;
        for (; i < len - 1; i++) {
            if (a[i] > root) { // 左子树的节点值都比根节点小
                break;
            }
        }
        int j = i;
        for (; j < len - 1; j++) {
            if (a[j] < root) { // 右子树的节点值都比根节点值大
                return false;
            }
        }

        boolean left = true;
        if (i > 0) {
            left = get(a, i);
        }
        boolean right = true;
        if (i < len - 1) {
            right = get(ArrayUtils.subarray(a, i, len - 1), len - i - 1);
        }

        return left && right;

    }

    public static void main(String[] args) {
        boolean r = get(new int[]{5,7,6,9,11,10,8}, 7);
        System.out.println(r);
    }


}
