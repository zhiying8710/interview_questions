package me.binge.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 太复杂
 * @author Bingege
 *
 * @param <E>
 */
public class Q2<E extends Comparable<E>> implements Iterable<E> {

    private class Node {

        private E val;
        private E min;

        public Node(E val, E min) {
            super();
            this.val = val;
            this.min = min;
        }

        public E getVal() {
            return val;
        }

        public E getMin() {
            return min;
        }
    }

    private LinkedList<Node> stack = new LinkedList<Node>();

    private E currMin = null;

    public E min() {
        return currMin;
    }

    public void push(E e) {
        if (currMin == null) {
            currMin = e;
        } else {
            if (e.compareTo(currMin) < 0) {
                currMin = e;
            }
        }
        Node node = new Node(e, currMin);
        stack.push(node);
    }

    public E pop() {

        Node node = stack.pop();
        if (node == null) {
            return null;
        }

        currMin = node.getMin();
        E val = node.getVal();

        return val;

    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorBuilder().trans(stack.iterator(), new Function() {

            @Override
            public E apply(Node node) {
                return node.getVal();
            }
        });
    }

    private abstract class Function {

        abstract E apply(Node node);

    }

    private class IteratorBuilder {

        public Iterator<E> trans(Iterator<Node> iterator, Function func) {
            List<E> newStack = new ArrayList<E>();
            while (iterator.hasNext()) {
               Q2<E>.Node next = iterator.next();
                newStack.add(func.apply(next));
            }
            return newStack.iterator();
        }
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Q2<Integer> q2 = new Q2<Integer>();
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
