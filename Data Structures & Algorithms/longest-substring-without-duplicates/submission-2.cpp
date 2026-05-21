class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        /* "thequickbrownfoxjumpsoverthelazydogthequickbrownfoxjumpsovert" 
        "zxyzxyz"
        l=0
        r=0
        hash map 

        */
        int n = s.size();
        unordered_map<char,int> mp;
        int longestSubstringLength = 0;
        int l=0,r=0;
        for(int i=0;i<n;i++){
            char ch = s[i];
            if(mp.find(ch)!=mp.end() && mp[ch]>=l){
                l=mp[ch]+1;
            }
            mp[ch] = i;
            longestSubstringLength = max(longestSubstringLength, mp[ch]-l+1);

        }
        return longestSubstringLength;
    }
};
