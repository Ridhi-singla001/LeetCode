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
class Solution 
{
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    // If either of the input arrays are empty, the tree is empty, so return null
    if (inorder.length == 0 || postorder.length == 0) return null;
    
    // Initialize indices to the last elements of the inorder and postorder traversals
    int ip = inorder.length - 1;
    int pp = postorder.length - 1;

    // Create an empty stack to help us build the binary tree
    Stack<TreeNode> stack = new Stack<TreeNode>();
    // Initialize prev to null since we haven't processed any nodes yet
    TreeNode prev = null;
    // Create the root node using the last element in the postorder traversal
    TreeNode root = new TreeNode(postorder[pp]);
    // Push the root onto the stack and move to the next element in the postorder traversal
    stack.push(root);
    pp--;

    // Process the rest of the nodes in the postorder traversal
    while (pp >= 0) {
        // While the stack is not empty and the top of the stack is the current inorder element
        while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
            // The top of the stack is the parent of the current node, so pop it off the stack and update prev
            prev = stack.pop();
            ip--;
        }
        // Create a new node for the current postorder element
        TreeNode newNode = new TreeNode(postorder[pp]);
        // If prev is not null, the parent of the current node is prev, so attach the node as the left child of prev
        if (prev != null) {
            prev.left = newNode;
        // If prev is null, the parent of the current node is the current top of the stack, so attach the node as the right child of the current top of the stack
        } else if (!stack.isEmpty()) {
            TreeNode currTop = stack.peek();
            currTop.right = newNode;
        }
        // Push the new node onto the stack, reset prev to null, and move to the next element in the postorder traversal
        stack.push(newNode);
        prev = null;
        pp--;
    }

    // Return the root of the binary tree
    return root;
    }
}