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
    bool isValidHelper(TreeNode* root,int left,int right){
        if(root==nullptr){
            return true;
        }
        if(!(root->val>left) || !(root->val<right)){
            return false;
        }

        return isValidHelper(root->left,left,root->val) && isValidHelper(root->right,root->val,right); 
    }

    bool isValidBST(TreeNode* root) {
        if(root==nullptr){
            return true;
        }
        return isValidHelper(root,INT_MIN,INT_MAX);
    }
};
