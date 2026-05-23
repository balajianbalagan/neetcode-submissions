class Solution {
public:
    void rec(vector<vector<int>> &ans,unordered_map<int,int> mp,vector<int> subans,vector<int> &nums,int ind){
        if(ind==nums.size()){
            ans.push_back(subans);
        }
        for(int i=0;i<nums.size();i++){
            if(mp[nums[i]]==0){
                subans.push_back(nums[i]);
                mp[nums[i]]++;
                rec(ans,mp,subans,nums,ind+1);
                subans.pop_back();
                mp[nums[i]]--;
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> subans;
        unordered_map<int,int> mp;

        rec(ans,mp,subans,nums,0);

        return ans;
    }
};
