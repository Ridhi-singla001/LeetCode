/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private static void markParent(TreeNode root,Map<TreeNode,TreeNode>parentMap,TreeNode target){
        Queue<TreeNode>q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current=q.poll();
            if(current.left!=null){
                parentMap.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right!=null){
                parentMap.put(current.right,current);
                q.offer(current.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>parentMap=new HashMap<>();
        markParent(root,parentMap,target);
        Map<TreeNode,Boolean>vis=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        q.offer(target);
        vis.put(target,true);
        int dist=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            if(dist==k) break;
            dist++;
            
            for(int i=0;i<size;i++){
                TreeNode current=q.poll();
                if(current.left!=null && vis.get(current.left)==null){
                    q.offer(current.left);
                    vis.put(current.left,true);
                }
                if(current.right!=null && vis.get(current.right)==null){
                    q.offer(current.right);
                    vis.put(current.right,true);
                }
                if(parentMap.get(current)!=null && vis.get(parentMap.get(current))==null){
                    q.offer(parentMap.get(current));
                    vis.put(parentMap.get(current),true);
                }
            }
        }
                List<Integer>res=new ArrayList<>();
                   while(!q.isEmpty()){
                       TreeNode current=q.poll();
                       res.add(current.val);
                   }
                   return res;
    }
}