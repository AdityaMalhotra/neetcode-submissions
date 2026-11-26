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

    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        int leftSmallest = kthSmallest(root.left,k);
        if(leftSmallest!=-1){
            return leftSmallest;
        }
        count++;
        if(count == k){
            return root.val;
        }
        int rightSmallest = kthSmallest(root.right,k);
        if(rightSmallest!=-1){
            return rightSmallest;
        }

        return -1;
    }
}
