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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        long sum = Integer.MIN_VALUE;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            level++;
            long cur = 0;
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                long val = (long) temp.val;
                cur += val;
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            if(cur > sum){
                res = level;
                sum = cur;
            }
            // level++;
        }
        return res;
    }
}