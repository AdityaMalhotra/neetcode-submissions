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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p,q,root);
    }

    private TreeNode lca(TreeNode root,TreeNode p, TreeNode q,TreeNode result){
        if(root == null){
            return null;
        } 

        if(root == p || root == q){
            return root;
        }

        TreeNode leftFound = lca(root.left,p,q,result);
        TreeNode rightFound = lca(root.right,p,q,result);

        if(leftFound!=null && rightFound!=null){
            result = root;
        }
        if(leftFound == null){
            result = rightFound;
        }
        if(rightFound == null){
            result = leftFound;
        }

        return result;
    }
}
