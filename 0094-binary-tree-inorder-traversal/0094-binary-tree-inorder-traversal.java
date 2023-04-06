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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList < Integer > inOrder = new ArrayList < > ();
        inOrderTrav(root, inOrder);
        return inOrder;
    }
    static void inOrderTrav(TreeNode curr, ArrayList < Integer > inOrder) {
        if (curr == null)
            return;

        inOrderTrav(curr.left, inOrder);
        inOrder.add(curr.val);
        inOrderTrav(curr.right, inOrder);
    }
}