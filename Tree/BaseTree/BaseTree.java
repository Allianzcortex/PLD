package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 树
 */

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int newVal) {
        this.val = newVal;
        this.left = null;
        this.right = null;
    }
}

public class Tree {
    TreeNode root;

    public void insertLeft(TreeNode root, int val) {
        root.left = new TreeNode(val);
    }

    public void insertRight(TreeNode root, int val) {
        root.right = new TreeNode(val);
    }

    public void printPreorser(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        printPreorser(root.left);
        printPreorser(root.right);
    }

    /*
    Leetcode 102 leetcode-binary-tree-level-order-traversal-java
    从左到右，一层套一层
       3
   / \
  9  20
    /  \
   15   7
   的输出结果为： {3,9,20,#,#,15,7}

   思路是用一个 Queue 来存储，FIFO
   ......
     */

    public ArrayList<ArrayList<Integer>> levelOrderTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode target = queue.remove();

        }
    }


    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode root = new TreeNode(1);
        /*
        构造一颗如下的树
                    1
                  /   \
                 2    3
                / \  / \
               4  5  6  7
         */
        tree.insertLeft(root, 2);
        tree.insertLeft(root.left, 4);
        tree.insertRight(root.left, 5);
        tree.insertRight(root, 3);
        tree.insertLeft(root.right, 6);
        tree.insertRight(root.right, 7);

        tree.printPreorser(root); // 先序遍历 1->2->4->5->3->6->7

    }
}

