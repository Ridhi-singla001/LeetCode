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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=  new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean status=  true;

        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ;i<n;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            if(!status){
                Collections.reverse(temp);
            }
            res.add(temp);
            status = !status;

        }
        return res;

    }
}