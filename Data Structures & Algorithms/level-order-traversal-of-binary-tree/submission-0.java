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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int queueLength = queue.size();
            for(int i = 0;i<queueLength;i++){
                TreeNode polled = queue.poll();
                if (polled.left!=null) { queue.offer(polled.left);}
                if (polled.right!=null) { queue.offer(polled.right);}
                subList.add(polled.val);
            }
            result.add(subList);
        }
        return result;
    }
}
