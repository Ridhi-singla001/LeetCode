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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        
        int lh=getHeightLeft(root);
        int rh=getHeightRight(root);
        
        if(lh==rh) return((2<<(lh))-1);
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }
    public int getHeightLeft(TreeNode root){
        int cnt=0;
        while(root.left!=null){
            cnt++;
            root=root.left;
        }
        return cnt;
    }
    public int getHeightRight(TreeNode root){
        int cnt=0;
        while(root.right!=null){
            cnt++;
            root=root.right;
        }
        return cnt;
    }
}