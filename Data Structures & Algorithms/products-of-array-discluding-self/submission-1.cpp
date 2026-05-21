class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> lprodarray(n,1),rprodarray(n,1);
        int lprod = 1,rprod=1, j=n-1;
        for(int i=0;i<n;i++){
            lprodarray[i] = lprod;
            lprod *= nums[i];
        
            rprodarray[j] = rprod;
            rprod *= nums[j];
            j--;
        }

        for(int i=0;i<n;i++){
            lprodarray[i] *= rprodarray[i];
        }

        return lprodarray;

    }
};
