package me.binge.questions;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 输入一个单向链表，输出该链表中倒数第 k 个结点, 链表的倒数第0个结点为链表的尾指针。 //此题一出，相信，稍微有点 经验的同志，都会说到：
 * ------------------------ 设置两个指针 p1,p2 首先 p1和 p2都指向 head 然后 p2向前走 n 步，这样 p1和
 * p2之间就间隔 k 个节点 然后 p1和 p2同时向前走, 如果p2到达了尾部, 则 p1即为倒数第 k个节点
 *
 * @author Bingege
 *
 */
public class Q13 {

    /**
     * 使用迭代器实现同时迭代
     * @param l
     * @param k
     * @return
     */
    public static Integer getK(LinkedList<Integer> l, int k) {

        if (l.size() < k) {
            return null;
        }

        Iterator<Integer> i1 = l.iterator();
        Iterator<Integer> i2 = l.iterator();


        for (int i = 0; i < k; i++) {
            i2.next();
        }
        Integer r = null;
        Integer ke = null;
        // 如果ke != l.getLast(), 表示 i2还没到达尾部
        while (ke != l.getLast()) {

            r = i1.next();
            ke = i2.next();

        }

        return r;
    }

    public static void main(String[] args) {

        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);

        System.out.println(getK(l, 4));
    }


}
