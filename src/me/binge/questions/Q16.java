package me.binge.questions;

import java.util.LinkedList;

import me.binge.questions.common.BSTree;

/**
 * 输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。
 * 例如输入
 *    8
 *   / \
 *  6 10
 * / \ / \
 * 5 7 9 11
 *
 * 输出8 6 10 5 7 9 11。
 *
 * 这种遍历方式实际上是一种广度优先遍历。
 * 因此这道题的本质是在二元树上实现广度优先遍历。
 * @author Bingege
 *
 */
public class Q16 {


    public static void print(BSTree tree) {

        LinkedList<BSTree> queue = new LinkedList<BSTree>();

        queue.push(tree);

        while (!queue.isEmpty()) {

            BSTree t = queue.pop();

            System.out.print(t.getVal());
            System.out.print(" ");

            if (t.getLeft() != null && t.getLeft().getVal() != null) {
                queue.addLast(t.getLeft());
            }
            if (t.getRight() != null && t.getRight().getVal() != null) {
                queue.addLast(t.getRight());
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

        print(tree);

    }

}
