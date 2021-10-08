package org.github.dsa.algorithms.morrisTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Step 1: Initialize current as root
 * <p>
 * Step 2: While current is not NULL,
 * <p>
 * If current does not have left child
 * <p>
 * a. Add current’s value
 * <p>
 * b. Go to the right, i.e., current = current.right
 * <p>
 * Else
 * <p>
 * a. In current's left subtree, make current the right child of the rightmost node
 * <p>
 * b. Go to this left child, i.e., current = current.left
 * <p>
 * <p>
 * For example:
 * <p>
 * <p>
 * 1
 * /   \
 * 2     3
 * / \   /
 * 4   5 6
 * <p>
 * First, 1 is the root, so initialize 1 as current, 1 has left child which is 2, the current's left subtree is
 * <p>
 * 2
 * / \
 * 4   5
 * So in this subtree, the rightmost node is 5, then make the current(1) as the right child of 5. Set current = cuurent.left (current = 2). The tree now looks like:
 * <p>
 * 2
 * / \
 * 4   5
 * \
 * 1
 * \
 * 3
 * /
 * 6
 * For current 2, which has left child 4, we can continue with thesame process as we did above
 * <p>
 * 4
 * \
 * 2
 * \
 * 5
 * \
 * 1
 * \
 * 3
 * /
 * 6
 * then add 4 because it has no left child, then add 2, 5, 1, 3 one by one, for node 3 which has left child 6, do the same as above. Finally, the inorder taversal is [4,2,5,1,6,3].
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }

    /* Definition for a binary tree node. */
    public class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversalRestoreTree(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    nodes.add(cur.val);
                    cur = cur.right;
                }
            } else {
                nodes.add(cur.val);
                cur = cur.right;
            }
        }
        return nodes;
    }
}