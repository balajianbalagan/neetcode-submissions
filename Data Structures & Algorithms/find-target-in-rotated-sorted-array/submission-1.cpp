class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n = nums.size();
        int left=0,right=n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                // if left half is sorted
                if(nums[left]<=target && nums[mid]>=target){
                   // if in range of sorted part 
                   right = mid;
                }else{
                    left = mid+1;
                }
            }else{
                // if right half is sorted
                if(nums[mid]<=target && nums[right]>=target){
                   // if in range of sorted part 
                   left = mid;
                }else{
                    right = mid-1;
                }
            }


        }
        return -1;
    }
};
