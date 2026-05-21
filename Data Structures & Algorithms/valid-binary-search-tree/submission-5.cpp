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
    bool isValidHelper(TreeNode* root,int val,int g=0){
        if(root==nullptr){
            return true;
        }
        if(g==0){
            if(root->val>=val){
                return false;
            }
        }else{
            if(root->val<=val){
                return false;
            }
        }
        return isValidHelper(root->left,val,g) && isValidHelper(root->right,val,g); 
    }

    bool isValidBST(TreeNode* root) {
        if(root==nullptr){
            return true;
        }
        if(root->left==nullptr && root->right==nullptr){
            return true;
        }
        bool isValidL = root->left ?  isValidHelper(root->left,root->val,0) : true;
        bool isValidR = root->right ?  isValidHelper(root->right,root->val,1) : true;
        if(!isValidL || !isValidR){
            return false;
        }else{
            return isValidBST(root->left) && isValidBST(root->right);
        }
    }
};
