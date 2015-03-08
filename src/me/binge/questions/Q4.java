package me.binge.questions;

import java.util.ArrayList;
import java.util.List;

import me.binge.questions.common.BSTree;

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


    public int sum(List<Integer> is) {
        int sum = 0;
        for (Integer i : is) {
            sum += i;
        }
        return sum;
    }

    public void getPaths(BSTree tree, int n, List<Integer> path) {
        if (path == null) { // 顶点
            path = new ArrayList<Integer>();
        }
        path.add(tree.getVal());
        int sum = sum(path);
        if (sum == n && tree.getLeft().getVal() == null && tree.getRight().getVal() == null) { // 叶子节点
            System.out.println(StringUtils.join(path.toArray(), ","));
        } else {

            if (tree.getLeft().getVal() != null) {
                getPaths(tree.getLeft(), n, path);
                path.remove(path.size() - 1);

            }
            if (tree.getRight().getVal() != null) {
                getPaths(tree.getRight(), n, path);
                path.remove(path.size() - 1);
            }
        }



    }

    public static void main(String[] args) {

        BSTree tree = new BSTree();
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
