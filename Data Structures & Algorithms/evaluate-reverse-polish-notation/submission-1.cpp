class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> st;
        int n = tokens.size();
        int s1,s2,s3;
        for(int i=0;i<n;i++){
           string token = tokens[i];
            if (token=="+"){
                    s2 = st.top();
                    st.pop();
                    s1 = st.top();
                    st.pop();
                    st.push(s1+s2);
                    cout<<"+ "<<s1+s2<<endl;
                }else if(token=="-"){
                    s2 = st.top();
                    st.pop();
                    s1 = st.top();
                    st.pop();
                    st.push(s1-s2);
                    cout<<"- "<<s1-s2<<endl;
                }else if(token=="*"){
                    s2 = st.top();
                    st.pop();
                    s1 = st.top();
                    st.pop();
                    st.push(s1*s2);
                    cout<<"* "<<s1*s2<<endl;
                }else if(token=="/"){
                    s2 = st.top();
                    st.pop();
                    s1 = st.top();
                    st.pop();
                    s3 = s1/s2;
                    st.push(s3);
                    cout<<s1<<"/ "<<s2<<" : "<<s3<<endl;
                }else{
                    st.push(stoi(token));
                }
            }
        return st.top();
    }
};
