class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
    public TreeNode delete(TreeNode root, int key){    
        if(root==null){
            return null;
        }    
        if(root.val==key){
            if(root.left==null && root.right==null){ // leaf node
                return null;
            }else if(root.left!=null && root.right==null){ //left child
                return root.left;
            }else if(root.left==null && root.right!=null){ // right child
                return root.right;
            }else if(root.left!=null && root.right!=null){
                int max=max(root.left);
                root.val=max;
                root.left = delete(root.left,max);
            }
        }        
        if(root.val>key){
            root.left = delete(root.left,key);
        }else if(root.val<key){
            root.right= delete(root.right,key);
        }
        return root;
    }
    public int max(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(max(root.right),root.val);
    }
}