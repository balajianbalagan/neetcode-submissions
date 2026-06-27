class Solution {
    public int rec(int[] nums,int i,int sum){
        if(i>=nums.length){
            return sum;
        }

        // pick
        int left = rec(nums,i+1,sum ^ nums[i]);

        // not pick
        int right = rec(nums,i+1,sum);

        return left + right;

    }
    public int subsetXORSum(int[] nums) {
        int sum = 0;

        sum = rec(nums,0,sum);


        return sum;
    }
}