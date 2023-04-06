public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> currentList = new ArrayList<Integer>();
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode currentNode = queue.poll();
                currentList.add(currentNode.val);
                if (currentNode.left!=null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right!=null) {
                    queue.offer(currentNode.right);                    
                }
            }
            result.add(currentList);
        }       
        return result;    
    }
}