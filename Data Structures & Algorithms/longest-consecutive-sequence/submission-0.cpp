class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        // brute - sort it and get elements by sliding window
        sort(nums.begin(),nums.end());
        int maxlcs = INT_MIN;
        int lcs = 0;
        if(nums.size()==0)return 0;
        if(nums.size()==1)return 1;
        for(int i=1;i<nums.size();i++){
            if(nums[i] - nums[i-1] == 1){
                lcs++;
            }else if(nums[i] - nums[i-1]>1){
                maxlcs = max(lcs,maxlcs);
                lcs = 0;
            }
        }
        maxlcs = max(lcs,maxlcs);
        return maxlcs+1;
    }
};
