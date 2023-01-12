class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root1, list);
        helper(root2, list);
        Collections.sort(list);
        return list;
    }
    public void helper(TreeNode root, ArrayList<Integer> l){
        if(root==null)
            return;
        l.add(root.val);
        helper(root.left,l);
        helper(root.right,l);
    }
}