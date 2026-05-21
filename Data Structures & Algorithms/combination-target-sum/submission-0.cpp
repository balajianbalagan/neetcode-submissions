class Solution {
public:
    void rec(vector<int> vec, vector<int>& nums, int i, int target,vector<vector<int>> &ans){
        if(target==0){
            ans.push_back(vec);
            return;
        }
        if(i==nums.size()){
            return;
        }

        //pick
        if(nums[i]<=target){
            vec.push_back(nums[i]);
            rec(vec,nums,i,target-nums[i],ans);
            vec.pop_back();
        }
        rec(vec,nums,i+1,target,ans);

        return;

    }
    vector<vector<int>> combinationSum(vector<int>& nums, int target) {
        /*
        [1,2]
        [],nums,i,target
        [],nums,0,3
        pick                not pick
        [1],0,2                 [],1,3
        [1,1],0,1 [1],1,2       [2],2,1
        */
        vector<vector<int>> ans;
        vector<int> vec;
        rec(vec,nums,0,target,ans);
        return ans;
    }
};
