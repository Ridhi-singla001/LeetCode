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
        ArrayList<Integer> leaf1 = new ArrayList<>();
        ArrayList<Integer> leaf2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        leaf1 = findLeafNodes(root1,leaf1);
        leaf2 = findLeafNodes(root2,leaf2);
        
        return leaf1.equals(leaf2);
         
    }
    
    public static ArrayList<Integer> findLeafNodes(TreeNode root,ArrayList<Integer> leaf){
        
        
        
        if(root == null){
            return null;
        }
        
        if(root.left == null && root.right == null){
            leaf.add(root.val);
        }
        
        findLeafNodes(root.left,leaf);
        findLeafNodes(root.right,leaf);
        
        return  leaf;
    }
}