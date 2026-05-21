class Solution {
public:
    int search(vector<int>& nums, int target) {
        int ans = -1;
        int n = nums.size();
        int l=0,r=n-1;

        while(l<=r){
            int mid = l+r/2;
            if(nums[mid]>target){
                r--;
            }else if(nums[mid]<target){
                l++;
            }else{
                ans = mid;
                return ans;
            }
        }


        return ans;
    }
};
