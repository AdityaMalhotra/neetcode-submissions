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

    private TreeNode lca(TreeNode root,TreeNode p, TreeNode q,TreeNode lca){
        if(root == null){
            return null;
        }
        if(root==p || root == q){
            return root;
        }

        TreeNode left = lca(root.left,p,q,lca);
        TreeNode right = lca(root.right,p,q,lca);

        if(left!=null && right!=null){
            lca = root;
        }else if(left!=null){
            lca = left;
        }else{
            lca = right;
        }

        return lca;
    }
}
