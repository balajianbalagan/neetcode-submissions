class Solution {
    public int rob(int[] nums) {
        /*
        2,9,8
        f(2)
        8 + f(0),f(1) 
        f(n) = max(nums[n]+f(i-2),f(i-1))
        */
        int n = nums.length;
        int[] dp = new int[n];
        // Arrays.fill(dp,-1);
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        if(n==1){
            return nums[0];
        }
        // dp[0] = nums[0];
        int prev2 = nums[0];
        // dp[1] = Math.max(nums[0],nums[1]);
        int prev = Math.max(nums[0],nums[1]);
        int curr = 0;
        for(int i=2;i<n;i++){
            // dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            curr = Math.max(prev2+nums[i],prev);
            prev2 = prev;
            prev = curr;
        }
        return curr;


        // return dp[n-1];
    }
}
