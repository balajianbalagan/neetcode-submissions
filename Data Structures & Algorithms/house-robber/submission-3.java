class Solution {
    public int rec(int i,int[] nums,int[] dp){
        if(i==1){
            return Math.max(nums[i],nums[i-1]);
        }
        if(i==0){
            return nums[i];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i] = Math.max(nums[i]+rec(i-2,nums,dp),rec(i-1,nums,dp));
    }
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
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }


        return dp[n-1];
    }
}
