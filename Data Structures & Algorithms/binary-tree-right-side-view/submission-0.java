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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode lastPopped = null;
            for(int i = 0;i<size;i++){
                lastPopped = queue.poll();
                if(lastPopped.left!=null)
                    queue.offer(lastPopped.left);
                if(lastPopped.right!=null)
                    queue.offer(lastPopped.right);
            }
            result.add(lastPopped.val);
        }
        return result;
    }
}
