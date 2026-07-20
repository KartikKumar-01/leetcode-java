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
    int count = 0;
    public int countDominantNodes(TreeNode root) {
        postorder(root);
        return count;
    }
    private int postorder(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        int l = postorder(root.left);
        int r = postorder(root.right);
        int mx = Math.max(l, r);
        if(root.val >=  mx) count++;
        return Math.max(root.val, mx);
    }
}