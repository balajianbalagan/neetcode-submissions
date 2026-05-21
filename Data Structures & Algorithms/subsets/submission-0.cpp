class Solution {
public:

    void rec(vector<vector<int>>& ans,vector<int>& nums, int i,vector<int> vec){
        if(i==nums.size()){
            ans.push_back(vec);
            return;
        }
        vec.push_back(nums[i]);
        rec(ans,nums,i+1,vec);
        vec.pop_back();
        rec(ans,nums,i+1,vec);
        return;
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        /*  
        0 1 2
        
        0               []
        01 0            1  []
        012 01 02 0     12  1 2 [] 
        
        */
        vector<vector<int>> ans;
        vector<int> vec;
        rec(ans,nums,0,vec);

        return ans;

    }
};
