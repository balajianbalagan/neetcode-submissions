class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        //initialize
        //for j->N
            // make the change that can make window valid/invalid
            //  while invalid 
                // shrink
            // update
        // what is state? -> map of elements
        // how to determine if its invalid -> if count of an element becomes negative
        int j=0,i=0,N=s2.size();
        unordered_map<char,int> mp;
        for(int k=0;k<s1.size();k++){
            mp[s1[k]]++;
        }
        for(;j<N;++j){
            mp[s2[j]]--;
            while(mp[s2[j]]<0 && i<=j){
                mp[s2[i++]]++;
            }
            if(j-i+1==s1.size()){
                return true;
            }
        }
    return false;
    }
};
