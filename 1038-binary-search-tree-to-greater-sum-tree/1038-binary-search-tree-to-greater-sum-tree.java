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
    public int sol(TreeNode root, int sum){
        if(root==null){
            return sum;
        }
        int rSum=sol(root.right,sum);
        int val=rSum+root.val;
        root.val=val;
        int lSum=sol(root.left,val);
        if(root.left==null) return val;
           return lSum;
    }
    public TreeNode bstToGst(TreeNode root) {
        sol(root,0);
        return root;
    }
    
}
