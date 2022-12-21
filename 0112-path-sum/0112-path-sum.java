class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return sol(root,targetSum,0,root);
    }
    
    public boolean sol(TreeNode root, int targetSum,int sum,TreeNode prev){
        
        if(root==null){
            if(prev.left==null &&prev.right==null){           
            if(sum==targetSum){
                return true;
            }
        }
            return false;
        }
        boolean lf = sol(root.left,targetSum,root.val+sum,root);
         boolean rt = sol(root.right,targetSum,root.val+sum,root);
        
        return lf||rt;
    }
}