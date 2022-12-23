class Solution {
    class pair
    {
        int dia=0;
        int ht=-1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
       
    pair ans=sol(root);
        return ans.dia;
        
    }
    public pair sol(TreeNode root)
    {
        
        if(root==null)
        {

            return new pair();
        }
       pair left= sol(root.left);
        pair right=sol(root.right);
        pair p=new pair();
        p.ht=Math.max(left.ht,right.ht)+1;
         int dia=left.ht+right.ht+2;
        p.dia=Math.max(left.dia,Math.max(right.dia,dia));
        
        return p;
        
        
    }
    
    
    }