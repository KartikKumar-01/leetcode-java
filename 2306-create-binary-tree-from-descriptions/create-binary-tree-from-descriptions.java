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
    HashMap<Integer, TreeNode> map;
    public TreeNode createBinaryTree(int[][] descriptions) {
        map = new HashMap<>();
        HashSet<Integer> childs = new HashSet<>();
        for(int[] d : descriptions){
            int p = d[0];
            int c = d[1];
            int l = d[2];
            TreeNode parent = map.getOrDefault(p, new TreeNode(p));
            TreeNode child = map.getOrDefault(c, new TreeNode(c));
            childs.add(c);
            if(l == 1) parent.left = child;
            else parent.right = child;
            map.put(p, parent);
            map.put(c, child);
        }
        for(int key : map.keySet()){
            if(!childs.contains(key)) return map.get(key);
        }
        return null;
    }
}