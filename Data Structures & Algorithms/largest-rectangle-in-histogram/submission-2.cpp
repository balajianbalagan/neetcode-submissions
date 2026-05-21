class Solution {
public:
    vector<int> pse(vector<int>& heights){
        int n = heights.size();
        vector<int> psev(n,-1);
        stack<pair<int,int>> st;
        for(int i=0;i<n;i++){
            while(!st.empty() && st.top().first >= heights[i]){
                st.pop();
            }
            int pseval = !st.empty() ? st.top().second : -1;
            psev[i] = pseval;
            st.push({heights[i],i});
        }
        return psev;
    }
    vector<int> nge(vector<int>& heights){
        int n = heights.size();
        vector<int> ngev(n,-1);
        stack<pair<int,int>> st;
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && st.top().first >= heights[i]){
                st.pop();
            }
            int ngeval = !st.empty() ? st.top().second : n;
            ngev[i] = ngeval;
            st.push({heights[i],i});
        }
        return ngev;
    }
    int largestRectangleArea(vector<int>& heights) {
        
        vector<int> psev = pse(heights);
        vector<int> ngev = nge(heights);
        int maxarea = 0;
        int n = heights.size();
        if(n==1)return heights[0];
        for(int i=0;i<n;i++){
            maxarea = max(maxarea, heights[i] * (ngev[i] - psev[i] - 1));
            // cout<<"Heights "<<heights[i]<<"\nNext greater "<<ngev[i]<<"\nPrev Smaller "<<psev[i]<<"\nMax are "<<maxarea<<"\n"<<endl;
        }

        return maxarea;
    }
};
