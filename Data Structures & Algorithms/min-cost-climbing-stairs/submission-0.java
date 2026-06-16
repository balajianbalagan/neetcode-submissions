class Solution {
    public int rec(int i,int[] cost,int[] dp){
        if(i==0 || i==1){
            return 0;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        dp[i] = Math.min(cost[i-1] + rec(i-1,cost,dp), cost[i-2]+rec(i-2,cost,dp));
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        return rec(n,cost,dp);
    }
}
