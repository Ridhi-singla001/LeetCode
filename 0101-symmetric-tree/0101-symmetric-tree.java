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
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }
    private boolean isSymmetricHelp(TreeNode Tleft, TreeNode Tright){
        if(Tleft==null || Tright==null)return Tleft==Tright;
            
        if(Tleft.val!=Tright.val)return false;
        
        return isSymmetricHelp(Tleft.left,Tright.right)&&isSymmetricHelp(Tleft.right,Tright.left);
    }
}