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
        if (root==null) return new ArrayList();
        return sol(root);
    }
    public List<List<Integer>> sol(TreeNode root){
        int level=0;
        List<List<Integer>> ans=new ArrayList();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int i=0;
            int size=q.size();
            List<Integer> curlevel=new ArrayList();
            while(i<size){
                TreeNode temp=q.remove();
                curlevel.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                i++;
                
            }
            if(level%2!=0){
                int k=0;
                int j=curlevel.size()-1;
                while(k<j){
                    int temp=curlevel.get(k);
                    curlevel.set(k,curlevel.get(j));
                    curlevel.set(j,temp);
                    k++;
                    j--;
                    
                }
                ans.add(curlevel);
            }
            else{
                ans.add(curlevel);
            }
            level++;
        }
        return ans;
    }
}