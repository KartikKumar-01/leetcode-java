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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        return build(list, 0, list.size() - 1);
    }
    public void inorder(TreeNode root, List<TreeNode> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
    public TreeNode build(List<TreeNode> list, int left, int right){
        if(left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = list.get(mid);
        node.left = build(list, left, mid - 1);
        node.right = build(list, mid + 1, right);
        return node;
    }
}