package me.binge.questions;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 从二元树的所有根节点到叶子节点的所有路径中找出路径上值的和等于给定值的路径
 * 递归调用本质是一个压栈和出栈的过程.
 * 遍历二元树, 每到一个节点时将该节点的值放入一个 List, 如果不是叶子节点, 继续遍历并将 list 传递下去, 在遍历每个节点之后都需要将刚刚加入的节点的值移除
 * 如果是叶子节点, 则将 list 中得所有值进行相加得到和与给定的值比较, 相等则打印路径.
 * @author Bingege
 *
 */
public class Q4 {

    static class Tree {

        private Tree left;
        private Tree right;
        private Integer val;

        public Tree getLeft() {
            return left;
        }

        public void setLeft(Tree left) {
            this.left = left;
        }

        public Tree getRight() {
            return right;
        }

        public void setRight(Tree right) {
            this.right = right;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public void add(Integer v) {
            if (this.val == null) {
                this.val = v;
                this.left = new Tree();
                this.right = new Tree();
                return;
            }

            if (this.getVal() < v) {
                this.left.add(v);
            } else if (this.getVal() > v) {
                this.right.add(v);
            }

        }

        public void listAllPath(List<Integer> path, List<List<Integer>> paths) {

            if (path == null) { //顶点
                path = new ArrayList<Integer>();
            } else {
                List<Integer> path1 = new ArrayList<Integer>();
                path1.addAll(path);
                path = path1;
            }
            path.add(this.val);

            if (this.left.val == null && this.right.val == null) { //叶子
                paths.add(path);
            } else {
                if (this.left.val != null) {
                    this.left.listAllPath(path, paths);
                }
                if (this.right.val != null) {
                    this.right.listAllPath(path, paths);
                }
                path.remove(path.size() - 1);
            }
        }

    }


    public int sum(List<Integer> is) {
        int sum = 0;
        for (Integer i : is) {
            sum += i;
        }
        return sum;
    }

    public void getPaths(Tree tree, int n, List<Integer> path) {
        if (path == null) { // 顶点
            path = new ArrayList<Integer>();
        }
        path.add(tree.val);
        int sum = sum(path);
        if (sum == n && tree.left.val == null && tree.right.val == null) { // 叶子节点
            System.out.println(StringUtils.join(path.toArray(), ","));
        } else {

            if (tree.left.val != null) {
                getPaths(tree.left, n, path);
                path.remove(path.size() - 1);

            }
            if (tree.right.val != null) {
                getPaths(tree.right, n, path);
                path.remove(path.size() - 1);
            }
        }



    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.add(10);
        tree.add(5);
        tree.add(12);
        tree.add(4);
        tree.add(7);
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        tree.listAllPath(null, paths);
        for (List<Integer> path : paths) {
            System.out.println(StringUtils.join(path.toArray(), ","));
        }
        System.out.println("-------");
        new Q4().getPaths(tree, 22, null);
    }

}
