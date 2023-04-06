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
    public List<Integer> preorderTraversal(TreeNode root) {
       ArrayList < Integer > preOrder = new ArrayList < > ();
        preOrderTrav(root, preOrder);
        return preOrder; 
    }
    private static void preOrderTrav(TreeNode curr, ArrayList < Integer > preOrder) {
        if (curr == null)
            return;

        preOrder.add(curr.val);
        preOrderTrav(curr.left, preOrder);
        preOrderTrav(curr.right, preOrder); 
    }
}