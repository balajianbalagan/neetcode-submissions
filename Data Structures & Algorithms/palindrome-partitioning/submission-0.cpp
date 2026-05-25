class Solution {
public:
    void rec(vector<vector<string>>& ans,vector<string> vec,string &s,int ind){
        /*
        "aab"
        "a","a","b"
        */
        if(ind==s.size()){
            ans.push_back(vec);
            return;
        }
        string temp="";
        for(int i=ind;i<s.size();i++){
            temp+=s[i];
            if(isPalindrome(temp)){
                vec.push_back(temp);
                rec(ans,vec,s,i+1);
                vec.pop_back();
            }
        }


    }

    bool isPalindrome(string word){
        int n=word.size();
        int r=n-1;
        int l = 0;
        while(l<r){
            if(word[l]!=word[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    vector<vector<string>> partition(string s) {
        vector<vector<string>> ans;
        vector<string> vec;
        rec(ans,vec,s,0);

        return ans;
    }
};
