class Solution {
public:
    void genRec(int open, int closed,int &n,string par, vector<string> &ans){
        if(open+closed==n){
            ans.push_back(par);
            return;
        }else{
            if(open==closed){
                genRec(open+1,closed,n,par+"(",ans);
            }else{
                genRec(open,closed+1,n,par+")",ans);
                if(open<n/2){
                    genRec(open+1,closed,n,par+"(",ans);
                }

            }
        }
    }

    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        n *= 2;
        genRec(0,0,n,"",ans);
        return ans;
    }
};
