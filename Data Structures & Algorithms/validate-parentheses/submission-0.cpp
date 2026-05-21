class Solution {
public:
    char inverse(char ch){
        // cout<<"received : "<<ch<<endl;
        if(ch=='}')return '{';
        if(ch==')')return '(';
        if(ch==']')return '[';
        char et;
        return et;
    }
    bool isValid(string s) {
        int n = s.size();
        stack<char> st;
        for(int i=0;i<n;i++){
            if(st.empty()){
                cout<<s[i]<<endl;
                st.push(s[i]);
            }else{
                // cout<<st.top()<<" "<<inverse(s[i])<<endl;
                if(st.top()==inverse(s[i])){
                    st.pop();
                }else{
                    st.push(s[i]);
                }
            }
        }


        if(!st.empty()){
            return false;
        }else{
            return true;
        }

    }
};
