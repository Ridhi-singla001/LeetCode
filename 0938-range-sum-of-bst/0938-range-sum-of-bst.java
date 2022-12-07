class Solution 
{
    public int rangeSumBST(TreeNode root, int low, int high) 
    {
        if (root == null) return 0;
        int s = (root.val >= low && root.val <= high) ? root.val : 0;
        if (root.val >= low)  s += rangeSumBST(root.left,  low, high);
        if (root.val <= high) s += rangeSumBST(root.right, low, high);
        return s;
    }
}