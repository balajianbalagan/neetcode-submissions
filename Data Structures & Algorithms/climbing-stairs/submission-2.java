class Solution {
    public int rec(int i,int[] dp){
        if(dp[i]!=0)return dp[i];
        return dp[i] = rec(i-1,dp) + rec(i-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n==1)return 1;
        dp[1] = 1;
        dp[2] = 2;
        return rec(n,dp);
    }
}
