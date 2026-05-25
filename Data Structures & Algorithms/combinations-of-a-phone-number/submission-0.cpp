class Solution {
public:
    void rec(vector<string> &ans,string digits,string subans, int ind){
        if(ind==digits.size()){
            ans.push_back(subans);
            return;
        }
        string letters = getMapping(digits[ind]);
        for(int i=0;i<letters.size();i++){
            subans+=letters[i];
            rec(ans,digits,subans,ind+1);
            subans.pop_back();
        }

    }
    string getMapping(char digit){
        string letters = "";
        switch(digit){
            case '2':
                letters = "abc";
                break;
            case '3':
                letters = "def";
                break;
            case '4':
                letters = "ghi";
                break;
            case '5':
                letters = "jkl";
                break;
            case '6':
                letters = "mno";
                break;
            case '7':
                letters = "pqrs";
                break;
            case '8':
                letters = "tuv";
                break;
            case '9':
                letters = "wxyz";
                break;
            default:
                break;

        }
        return letters;
    }
    vector<string> letterCombinations(string digits) {
        /*

        3 -> def
        4 -> ghi




        345
        5 -> jkl
        dgj, dgk.......fgj, fgk......fil 


        fetch digits's string
            -> for loop through it
                for each element
                    -> add in position and do recursion for next step
                    -> pop it

        */
        vector<string> ans;
        if(digits==""){
            return ans;
        }
        rec(ans,digits,"",0);

        return ans;
    }
};
