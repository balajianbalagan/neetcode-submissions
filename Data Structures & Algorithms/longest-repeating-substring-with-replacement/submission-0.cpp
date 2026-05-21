class Solution {
public:
    int characterReplacement(string s, int k) {
        /*
        AAABABB k=1
        initialize
        loop
            => shrink the window
            => perform and update
            => grow

        */
        int left=0,right=0,n=s.size(),longest=0;
        unordered_map<char,int> mp;
        char maxElement = s[0];
        while(right<n){
            // perform
            mp[s[right]]++;
            if(mp[s[right]] > mp[maxElement]){
                maxElement = s[right];
            }
            int length = right-left+1;
            

            // shrinking
            if(length - mp[maxElement] > k){
                mp[s[left]]--;
                left++;
            }

            //update
            longest = max(longest,right-left+1);
            

            //grow the window
            right++;
        }



        return longest;
    }
};
