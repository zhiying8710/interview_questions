package me.binge.questions;

import java.util.ArrayList;
import java.util.List;
/**
 * 遍历二元查找树
 * @author Bingege
 *
 */
public class Q1 {

    private Q1 left;
    private Q1 right;
    private Integer val;

    public Q1 getLeft() {
        return left;
    }

    public void setLeft(Q1 left) {
        this.left = left;
    }

    public Q1 getRight() {
        return right;
    }

    public void setRight(Q1 right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void add(int val) {
        if (this.val == null) {
            this.setVal(val);
            this.setLeft(new Q1());
            this.setRight(new Q1());
            return;
        }

        if (this.val == val) {
            return;
        }

        if (val < this.val) {
            this.left.add(val);
        } else {
            this.right.add(val);
        }

    }

    //  中序遍历
    public void list(List<Integer> l) {

        if (this.left.val != null) {
            this.left.list(l);
        }

        l.add(this.val);

        if (this.right.val != null) {
            this.right.list(l);
        }



    }


    public static void main(String[] args) {

        Q1 q1 = new Q1();
        q1.add(10);
        q1.add(4);
        q1.add(6);
        q1.add(8);
        q1.add(12);
        q1.add(14);
        q1.add(15);
        q1.add(16);

        List<Integer> l = new ArrayList<Integer>();
        q1.list(l);
        for (Integer i : l) {
            System.out.println(i);
        }
    }
}
