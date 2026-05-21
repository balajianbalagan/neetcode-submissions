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
    void goodNodesHelper(TreeNode* root,int max,int &gn){
        if(root==nullptr){
            return;
        }
        if(root->val>=max){
            gn++;
            max = root->val;
        }
        goodNodesHelper(root->left,max,gn);
        goodNodesHelper(root->right,max,gn);
    }

    int goodNodes(TreeNode* root) {
        int gn = 0;
        int maxv = INT_MIN;
        goodNodesHelper(root,maxv,gn);

        return gn;
    }
};
