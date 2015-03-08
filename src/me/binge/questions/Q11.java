package me.binge.questions;

import me.binge.questions.common.BSTree;

/**
 * 求二叉树中节点的最大距离...
 *
 * 如果我们把二叉树看成一个图， 父子节点之间的连线看成是双向的， 我们姑且定义"距离"为两节点之间边的个数。 写一个程序，
 * 求一棵二叉树中相距最远的两个节点之间的距离。<br/>
 * <a href="http://www.cnblogs.com/miloyip/archive/2010/02/25/1673114.html"
 * >http://www.cnblogs.com/miloyip/archive/2010/02/25/1673114.html</a><br/>
 * ====== <br/>
 * 计算一个二叉树的最大距离有两个情况:<br/>
 * <ul>
 * <li>
 * 情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。</li>
 * <li>
 * 情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。</li>
 * </ul>
 * 1. 使用广度优先算法, 从任意一个节点开始, 查找出距离他最远的节点, 然后从这个节点开始, 找到距离他最远的节点,
 * 这两次找到的节点之间的距离即为最远距离<br/>
 *
 * 2. 情况 A 的最大的距离即为左右子树深度的和 + 1, 情况 B 是左子树或右子树的最大距离路径，取其大者。<br/>
 *
 * @author Bingege
 *
 */
public class Q11 {

    /**
     * 获取树的深度
     * @param lrTree
     * @return
     */
    public static int getDep(BSTree lrTree) {
        int ldep = 0;
        int rdep = 0;
        if (lrTree.getLeft().getVal() != null) {
            ldep = getDep(lrTree.getLeft());
        }
        if (lrTree.getRight().getVal() != null) {
            rdep = getDep(lrTree.getRight());
        }
        return Math.max(ldep, rdep) + 1;
    }

    static class Result {
        private int maxDep;
        private int maxDistance;

        public Result(int maxDep, int maxDistance) {
            this.maxDep = maxDep;
            this.maxDistance = maxDistance;
        }

        public int getMaxDep() {
            return maxDep;
        }

        public void setMaxDep(int maxDep) {
            this.maxDep = maxDep;
        }

        public int getMaxDistance() {
            return maxDistance;
        }

        public void setMaxDistance(int maxDistance) {
            this.maxDistance = maxDistance;
        }

        @Override
        public String toString() {
            return "Result [maxDep=" + (maxDep + 1) + ", maxDistance=" + maxDistance
                    + "]";
        }
    }

    /**
     * 叶子节点返回{0(最大深度 - 1), 0(最大距离)}, 到了父节点返回{1, 2}
     * @param tree
     * @return
     */
    public static Result getDistance(BSTree tree) {

        Result lr = new Result(-1, 0);
        Result rr = new Result(-1, 0);

        if (tree.getLeft().getVal() != null) {
            lr = getDistance(tree.getLeft());
        }

        if (tree.getRight().getVal() != null) {
            rr = getDistance(tree.getRight());
        }

        return new Result(Math.max(lr.getMaxDep() + 1, rr.getMaxDep() + 1), Math.max(Math.max(lr.getMaxDistance(), rr.getMaxDistance()), lr.getMaxDep() + rr.getMaxDep() + 2));

    }

//    public static Tree bfs(Tree tree, Tree start) {
//
//    }


    public static void main(String[] args) {

        BSTree tree = new BSTree();
        tree.add(10);
        tree.add(5);
        tree.add(12);

        System.out.println("max distance: " + getDistance(tree));
    }


}
