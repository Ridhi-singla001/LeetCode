/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        if(root==NULL)
        return root;
        if(depth==1){
            TreeNode* l=new TreeNode(val);
            l->left=root;
            root=l;
        }
        if(depth==2){
            TreeNode* l=new TreeNode(val);
            TreeNode* r=new TreeNode(val);
            TreeNode* l1=root->left;
            root->left=l;
            l->left=l1;
            TreeNode* r1=root->right;
            root->right=r;
            r->right=r1;
        }
        
        addOneRow(root->left,val,depth-1);
        addOneRow(root->right,val,depth-1);
        return root;
    }
};