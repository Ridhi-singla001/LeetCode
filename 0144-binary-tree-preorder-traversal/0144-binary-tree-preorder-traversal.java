public class Solution {

public List<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    traverse(root, list);
    return list;
}

public void traverse(TreeNode node, ArrayList<Integer> list) {
    if(node == null) {
        return;
    }
    
    list.add(node.val);
    traverse(node.left, list);
    traverse(node.right, list);
    
}
}