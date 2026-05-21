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

    max depth of left
    max depth of right
    if abs diff >1 return false

    recursive function that returns max depth 
    does a calculation after it gets left and right
 */

class Solution {
public:
    int depthAndIsBalanced(TreeNode* root,int depth){
        if(root==nullptr){
            return depth;
        }
        int right = depthAndIsBalanced(root->right,depth+1);
        int left = depthAndIsBalanced(root->left,depth+1);
        if(right == -1 || left == -1){
            return -1;
        }
        if(abs(right-left)>1){
            return -1;
        }else{
            return max(left,right);
        }
    }
    bool isBalanced(TreeNode* root) {
        int finalDepth = depthAndIsBalanced(root,0);
        if(finalDepth==-1){
            return false;
        }else{
            return true;
        }
    }
};
