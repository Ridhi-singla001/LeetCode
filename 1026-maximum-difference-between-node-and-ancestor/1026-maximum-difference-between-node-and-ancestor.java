class Solution {
    int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        return findMaxDiff(root,root.val,root.val);
    }

    public int findMaxDiff(TreeNode root,int maxAncestor, int minAncestor){
        
        if(root == null){
            return 0;
        }

        maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - minAncestor), Math.abs(maxAncestor - root.val)));
        if(root.val > maxAncestor){
            maxAncestor = root.val;
        }

        if(root.val < minAncestor){
            minAncestor = root.val;
        }

    	findMaxDiff(root.left, maxAncestor, minAncestor);
    	findMaxDiff(root.right, maxAncestor, minAncestor);

        return maxDiff;
    }
}