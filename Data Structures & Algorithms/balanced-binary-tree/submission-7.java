/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        int depth = getDepth(root);
        if(depth == -1){
            return false;
        }
        return true;
    }

    private int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = getDepth(node.left);
        if(left == -1){
            return -1;
        }
        int right = getDepth(node.right);
        if(right == -1){
            return -1;
        }

        int balance = Math.abs(left-right);
        if(balance > 1){
            return -1;
        }

        return 1+Math.max(left,right);
    }
}
