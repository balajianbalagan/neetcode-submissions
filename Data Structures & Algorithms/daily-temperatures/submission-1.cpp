class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> ans(n,0);
        stack<pair<int,int>> st;
        for(int i=n-1;i>=0;i--){
            if(st.empty()){
                st.push({temperatures[i],i});
                ans[i]=0;
            }else{
                int f=0;
                while(st.top().first<=temperatures[i]){
                    st.pop();
                    if(st.empty()){
                        ans[i]=0;
                        st.push({temperatures[i],i});
                        f=1;
                        break;
                    }
                }
                if(f==0){
                    ans[i] = st.top().second - i;
                    st.push({temperatures[i],i});
                }

            }
        }
        return ans;
    }
};
