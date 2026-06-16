class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        // what's base? n==1 or n==0
        if(n==2){
            return Math.min(cost[n-1],cost[n-2]);
        }
        if(n==1){
            return cost[n-1];
        }
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=n;i++){
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        }
        return dp[n];
    }
}
