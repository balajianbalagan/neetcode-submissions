class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        // brute
        unordered_map<int,int> mp;
        int maxC = INT_MIN;
        for(int i=0;i<nums.size();i++){
            mp[nums[i]]++;
            maxC = max(maxC,mp[nums[i]]);
        }
        vector<vector<int>> countmap(nums.size()+1);
        for(auto it:mp){
            countmap[it.second].push_back(it.first);
        }
        vector<int> ans;
        for(int i=maxC;i>=1;i--){
            if(ans.size()==k){
                break;
            }
            vector<int> sameFreq = countmap[i];
            if(sameFreq.size()==1){
                ans.push_back(sameFreq[0]);
            }else if(sameFreq.size()>1){
                int sfs = sameFreq.size()-1;
                ans.push_back(sameFreq[sfs]);
                countmap[i].pop_back();
                i++;
            }
        }
        
        return ans;
    }
};
