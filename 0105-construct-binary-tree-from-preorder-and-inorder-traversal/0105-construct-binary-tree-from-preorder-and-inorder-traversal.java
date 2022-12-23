class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return sol(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode sol(int[] preorder, int plo, int phi, int[] inorder, int ilo, int ihi)
    {
        if (plo>phi || ilo>ihi){
            return null;
        }
        TreeNode nn=new TreeNode();
        nn.val=preorder[plo];
        int nel=0;
        int si=0;
        for (int i=ilo; i<=ihi; i++){
            if(inorder[i]==preorder[plo]){
                si=i;
                break;
            }
            nel++;
        }
        nn.left=sol(preorder, plo+1, plo+nel, inorder, ilo, si-1);
        nn.right=sol(preorder, plo+nel+1, phi, inorder, si+1, ihi);
        return nn;
    } 
}