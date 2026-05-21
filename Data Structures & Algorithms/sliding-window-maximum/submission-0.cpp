class Solution {
public:
    void printMap(map<int,int> mp){
        for(auto it=mp.begin();it!=mp.end();++it){
            cout<<"First: "<<it->first<<" Second: "<<it->second<<endl;
        }
        cout<<endl;
    }
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        map<int,int> mp;
        vector<int> vec;
        int j=0,i=0,N=nums.size();
        for(;j<k-1;j++){
            mp[nums[j]]++;
        }
        for(;j<N;++j){
            mp[nums[j]]++;
            auto lastElementIterator = --mp.end();
            vec.push_back(lastElementIterator->first);
            // printMap(mp);
            if(--mp[nums[i]] == 0){
                mp.erase(nums[i]);
            }
            // printMap(mp);
            i++;
        }
        return vec;
    }
};
