class Solution {
public:

    string encode(vector<string>& strs) {
        // num#string
        string encodeds = "";
        for(int i=0;i<strs.size();i++){
            string subs = strs[i];
            int n = subs.size();
            encodeds += to_string(n)+"#"+subs;
        }
        return encodeds;
    }

    vector<string> decode(string s) {
        vector<string> vec;
        if(s==""){
            return vec;
        }
        // vec.push_back(s);
        string subs = "";
        string subsize = ""; 
        int subsizei = -1;
        for(int i=0;i<s.size();i++){
            if(s[i]!='#' && subsizei==-1){
                subsize+=s[i];
            }else if(s[i]=='#' && subsizei==-1){
                subsizei = stoi(subsize);
            }else{
                subsizei--;
                subs+=s[i];
                if(subsizei==0){
                    vec.push_back(subs);
                    subsizei=-1;
                    subsize="";
                    subs="";
                }
            }
            if(subsizei==0){
                vec.push_back(subs);
                subsizei=-1;
                subsize="";
                subs="";
            }
        }

        // find num
        // get string
        // add to vec



        return vec;
    }
};
