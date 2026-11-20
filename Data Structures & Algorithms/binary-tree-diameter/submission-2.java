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
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int depth = getDepth(root);
        return maxDiameter;
    }

    private int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        maxDiameter = Math.max(maxDiameter,leftDepth+rightDepth);

        return 1 + Math.max(leftDepth,rightDepth);
    }
}
