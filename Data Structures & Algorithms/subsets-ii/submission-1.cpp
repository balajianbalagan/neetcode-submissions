class Solution {
public:
    void rec(vector<vector<int>> &ans,vector<int> &nums,vector<int> vec, int ind){
        ans.push_back(vec);
        if(ind==nums.size()){
            return;
        }
        for(int i=ind;i<nums.size();i++){
            if(i>ind && nums[i]==nums[i-1]){
                continue;
            }
            
            vec.push_back(nums[i]);
            rec(ans,nums,vec,i+1);
            vec.pop_back();
            // rec(ans,nums,vec,ind+1);
        }
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> ans;
        sort(nums.begin(),nums.end());
        vector<int> vec;
        rec(ans,nums,vec,0);

        return ans;
    }
};
