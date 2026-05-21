class Solution {
public:
    int findMin(vector<int> &nums) {
        // int min = *min_element(nums.begin(),nums.end());
        // return min;
        int left = 0;
        int right = nums.size()-1;
        int min_element = 1001;
        if(right==0){
            return nums[0];
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[left] < nums[mid]){
                // left sorted
                min_element = min(nums[left],min_element);
                cout<<min_element<<endl;
                left = mid+1;
            }else if(nums[mid] < nums[right]){
                // right sorted
                min_element = min(nums[mid],min_element);
                cout<<min_element<<endl;
                right = mid - 1;
            }else{
                min_element = min(min(nums[left],nums[right]),min_element);
                left = mid+1;
            }
        }



        return min_element;

    }
};
