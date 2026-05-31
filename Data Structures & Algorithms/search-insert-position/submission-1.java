class Solution {
    public int searchInsert(int[] nums, int target) {
        /*

        */
        int lb=0;
        int ub=nums.length-1;
        int mid = 0;
        while(lb<ub){
            mid = (lb+ub)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                lb = mid+1;
            }else{
                ub = mid-1;
            }
        }
        System.out.println(mid+"| ub: "+ub+" | lb:"+lb);
        if(ub==-1)return 0;
        if(ub==nums.length)return ub-1;
        if(nums[ub]<target){
            return ub+1;
        }else{
            return ub;
        }
    }
}