class Solution {
public:
    int ans = 0;
   
     unordered_map<int, int> um;
    
    void helper(TreeNode* root){
        if(root==NULL) return ;
        
        um[root->val]++;
        
        
             if(root->left==NULL && root->right==NULL)
             {
                    int temp=0;
              for(int i=0; i<=9; i++)
                {
                   if(um[i]%2!=0) 
                   temp++;
                }
              if(temp<=1) ans++;
            
              }
         helper(root->left);
       
    helper(root->right);
       
    um[root->val]--;
        // removing the occurence of node, when we are going one step back
        
    }
    int pseudoPalindromicPaths (TreeNode* root) {
       
        helper(root);
        return ans;
    }
};