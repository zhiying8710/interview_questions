package me.binge.questions;

import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;

import me.binge.questions.common.BSTree;

/**
 * 输入一颗二元查找树，将该树转换为它的镜像，
 * 即在转换后的二元查找树中，左子树的结点都大于右子树的结点。
 * 用递归和循环两种方法完成树的镜像转换。
 * 例如输入：
 *   8
 *   / \
 *   6 10
 *  /\ /\
 * 5 7 9 11
 *
 * 输出：
 *   8
 *  /  \
 * 10   6
 * / \  / \
 *11  9 7  5
 * @author Bingege
 *
 */
public class Q15 {

    /**
     * 递归
     * @param tree
     * @param mirror
     */
    public static void mirror(BSTree tree) {

        BSTree t = tree.getLeft();
        tree.setLeft(tree.getRight());
        tree.setRight(t);

        if (tree.getLeft().getVal() != null) {
            mirror(tree.getLeft());
        }
        if (tree.getRight().getVal() != null) {
            mirror(tree.getRight());
        }

    }

    /**
     * 循环, 利用栈来模拟递归
     * @param tree
     * @param mirror
     */
    public static void mirror1(BSTree tree) {

        LinkedList<BSTree> stack = new LinkedList<BSTree>();

        stack.add(tree);

        while (!stack.isEmpty()) {

            BSTree top = stack.pop();
            BSTree t = top.getLeft();
            top.setLeft(top.getRight());
            top.setRight(t);


            if (top.getLeft() != null && top.getLeft().getVal() != null) {
                stack.push(top.getLeft());
            }
            if (top.getRight() != null && tree.getRight().getVal() != null) {
                stack.push(top.getRight());
            }

        }



    }

    public static void main(String[] args) {

        BSTree tree = new BSTree();
        tree.add(8);
        tree.add(6);
        tree.add(5);
        tree.add(7);
        tree.add(10);
        tree.add(9);
        tree.add(11);
        ArrayList<Integer> l = new ArrayList<Integer>();
        tree.list(l);
        System.out.println(StringUtils.join(l.toArray(), ','));

        mirror(tree);

        l = new ArrayList<Integer>();
        tree.list(l);
        System.out.println(StringUtils.join(l.toArray(), ','));

        tree = new BSTree();
        tree.add(8);
        tree.add(6);
        tree.add(5);
        tree.add(7);
        tree.add(10);
        tree.add(9);
        tree.add(11);

        mirror1(tree);

        l = new ArrayList<Integer>();
        tree.list(l);
        System.out.println(StringUtils.join(l.toArray(), ','));

    }


}
