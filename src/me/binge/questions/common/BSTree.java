package me.binge.questions.common;

import java.util.ArrayList;
import java.util.List;

public class BSTree {

    private BSTree left;
    private BSTree right;
    private Integer val;

    public BSTree getLeft() {
        return left;
    }

    public void setLeft(BSTree left) {
        this.left = left;
    }

    public BSTree getRight() {
        return right;
    }

    public void setRight(BSTree right) {
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
            this.left = new BSTree();
            this.right = new BSTree();
            return;
        }

        if (this.getVal() < v) {
            this.right.add(v);
        } else if (this.getVal() > v) {
            this.left.add(v);
        }

    }

    public void listAllPath(List<Integer> path, List<List<Integer>> paths) {

        if (path == null) { // 顶点
            path = new ArrayList<Integer>();
        } else {
            List<Integer> path1 = new ArrayList<Integer>();
            path1.addAll(path);
            path = path1;
        }
        path.add(this.val);

        if (this.left.val == null && this.right.val == null) { // 叶子
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

    //  前序遍历
    public void list(List<Integer> l) {
        l.add(this.val);

        if (this.left.val != null) {
            this.left.list(l);
        }

        if (this.right.val != null) {
            this.right.list(l);
        }
    }

}
