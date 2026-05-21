class Solution {
public:
    bool isValid(unordered_map<char,int> target){
        for(auto it=target.begin();it!=target.end();++it){
            // cout<<"checking validity mp["<<it->first<<"] : "<<it->second<<endl; 
            if(it->second>0)return false;
        }
        return true;

    }
    string minWindow(string s, string t) {
        /* Initialize vars
            for j -> N
                => perform operation to make valid
                => while valid
                    => update minimum
                    => shrink window 
        */
        int i=0,j=0,N1=s.size(),N2=t.size(),matchingStrings=t.size();
        unordered_map<char,int> target,mp;
        string minString = "";
        for(int k=0;k<N2;k++){
            target[t[k]]++;
        }
        for(;j<N1;++j){
            if(target.find(s[j])!=target.end()){
               target[s[j]]--;
            }
            while(isValid(target)){
                // cout<<"matched strings size : "<<j-i+1<<" l:"<<i<<" r:"<<j<<endl;
                if(j-i+1 < minString.size() || minString==""){
                    minString = s.substr(i,j-i+1);
                }
                if(target.find(s[i])!=target.end()){
                    target[s[i]]++;
                }
                i++;
            }
        }
        return minString;



    }
};
