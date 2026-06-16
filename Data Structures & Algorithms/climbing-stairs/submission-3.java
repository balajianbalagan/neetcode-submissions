// public int rec(int i,int[] dp){
//         if(dp[i]!=0)return dp[i];
//         return dp[i] = rec(i-1,dp) + rec(i-2,dp);
//     }
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         if(n==1)return 1;
//         dp[1] = 1;
//         dp[2] = 2;
//         return rec(n,dp);
//     }

class Solution {
    public int rec(int i,int[] dp){
        if(dp[i]!=0)return dp[i];
        return dp[i] = rec(i-1,dp) + rec(i-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n<=2)return n;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
