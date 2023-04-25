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
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }
    
    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        count--;
        if(count == 0) {
            res = root.val;
            return;
        } 
        dfs(root.right);
    }
}