class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        set<vector<int>> st;
        
        // handle <= 3 size arrays
        int n = nums.size();
        if(n>3){
            for(int i=0;i<n-2;i++){
                int l=i+1;
                int r=n-1;
                while(l<r){
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum==0){
                        st.insert({nums[i], nums[l], nums[r]});
                        l++;
                    }else if(sum>0){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
        }else{
            if(n==3){
                int sum = nums[0] + nums[1] + nums[2];
                if(sum==0){
                    st.insert({nums[0],nums[1],nums[2]});
                }
            }
        }
        vector<vector<int>> ans(st.begin(),st.end());
        

        return ans;
    }
};
