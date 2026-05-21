class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        /* "thequickbrownfoxjumpsoverthelazydogthequickbrownfoxjumpsovert" 
        l=0
        r=0
        hash map 

        */
        int n = s.size();
        unordered_map<int,int> mp;
        int longestSubstringLength = 0;
        int l=0,r=0;
        while(l<n && r<n){
            if(mp.find(s[r])==mp.end()){
                mp[s[r]] = r;
                if(r-l+1 > longestSubstringLength){
                    cout<<r-l+1<<endl;
                    cout<<"l: "<<l<<" r: "<<r<<endl;
                    cout<<"s[l]: "<<s[l]<<" s[r]: "<<s[r]<<endl;
                    cout<<endl;
                }
                longestSubstringLength = max(longestSubstringLength, r-l+1);
                r++;
            }else{
                cout<<"found element "<<s[r]<<" at "<<mp[s[r]]<<endl;
                l=mp[s[r]]+1;
                r = l;
                mp.clear();
            }
            
        }
        return longestSubstringLength;
    }
};
