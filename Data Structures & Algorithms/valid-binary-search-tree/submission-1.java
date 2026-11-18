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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE); //2.intMIN,intMAX
    }
    private boolean isValidBST(TreeNode root, int maxVal, int minVal){
        if(root == null){ //2
            return true;
        }
        int val = root.val; //2
        if(val <= minVal || val >= maxVal){ //2<MIN || 2>MAX Nope
            return false;
        }
        
        return isValidBST(root.left,val,minVal) && isValidBST(root.right,maxVal,val);
    }
}
