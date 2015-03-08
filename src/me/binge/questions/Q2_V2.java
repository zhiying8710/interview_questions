package me.binge.questions;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 实现一个包含 min 函数的栈, 能够找出栈中最小的元素, 并且时间复杂度是O(1).
 * 使用辅助栈记录 min
 * @author Bingege
 *
 * @param <E>
 */
public class Q2_V2<E extends Comparable<E>> implements Iterable<E> {

    private LinkedList<E> valStack = new LinkedList<E>();
    private LinkedList<E> minStack = new LinkedList<E>();

    public void push(E e) {
        if (minStack.isEmpty() || minStack.getFirst().compareTo(e) > 0) {
            minStack.push(e);
        } else {
            minStack.push(minStack.getFirst());
        }
        valStack.push(e);

    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E v = valStack.pop();
        try {
            return v;
        } finally {
            minStack.pop();
        }

    }

    public E min() {
        if (isEmpty()) {
            return null;
        }
        return minStack.getFirst();
    }


    @Override
    public Iterator<E> iterator() {
        return valStack.iterator();
    }

    public boolean isEmpty() {
        boolean b = valStack.isEmpty();
        if (b) {
            minStack.clear();
        }
        return b;
    }

    public static void main(String[] args) {

        Q2_V2<Integer> q2 = new Q2_V2<Integer>();
        q2.push(10);
        q2.push(7);
        q2.push(3);
        q2.push(3);
        q2.push(8);
        q2.push(5);
        q2.push(2);
        q2.push(6);

        for (Integer i : q2) {
            System.out.println(i);
        }

        while (!q2.isEmpty()) {
            System.out.println("min: " + q2.min() + ", val: " + q2.pop());
        }
    }



}
