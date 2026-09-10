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
    private int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return ans;
    }
    private int[] helper(TreeNode root){
        if(root == null) return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int sum = root.val + left[0] + right[0];
        int cnt = 1 + left[1] + right[1];
        if(cnt > 0 && (sum / cnt) == root.val) ans++;

        return new int[]{sum, cnt};
    }
}