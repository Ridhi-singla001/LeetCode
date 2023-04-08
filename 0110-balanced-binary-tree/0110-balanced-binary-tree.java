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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        
        int lh=findH(root.left);
        int rh=findH(root.right);
        
        if(Math.abs(lh-rh)>1) return false;
        
        boolean lans= isBalanced(root.left);
        boolean rans= isBalanced(root.right);
        
        if(!lans || !rans) return false;
        
        return true;
    }
    public static int findH(TreeNode root){
        if(root==null) return 0;
        
        int lh=findH(root.left);
        int rh=findH(root.right);
        
        return 1+Math.max(lh,rh);
    }
}