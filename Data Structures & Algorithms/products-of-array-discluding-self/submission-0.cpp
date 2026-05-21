class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> lprodarray(n,1),rprodarray(n,1);
        int lprod = 1,rprod=1;
        for(int i=0;i<n;i++){
            lprodarray[i] = lprod;
            lprod *= nums[i];
        }

        for(int i=n-1;i>=0;i--){
            rprodarray[i] = rprod;
            rprod *= nums[i];
        }

        for(int i=0;i<n;i++){
            lprodarray[i] *= rprodarray[i];
        }

        return lprodarray;

    }
};
