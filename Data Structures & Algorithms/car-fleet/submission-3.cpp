class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<pair<int,float>> vec;
        int n = position.size();
        for(int i=0;i<n;i++){
            vec.push_back({position[i],speed[i]});
        }
        sort(vec.begin(),vec.end());
        stack<float> ans;
        for(int i=n-1;i>=0;i--){
            // cout<<"position : "<<vec[i].first<<" speed : "<<vec[i].second<<endl;
            if(ans.empty()){
                float time = (target - vec[i].first)/vec[i].second;
                ans.push(time);
            }else{
                float t1 = ans.top();
                float time = (target - vec[i].first)/vec[i].second;
                // cout<<" this car: "<<time<<"\n top time:"<<t1<<endl;
                if(time>t1){
                    ans.push(time);
                }
            }
        }

        return ans.size();
        
    }
};
