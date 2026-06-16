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
    public int climbStairs(int n) {
        if(n<=2)return n;
        // dp[1] = 1;
        int prev2 = 1;
        // dp[2] = 2;
        int prev = 2;
        int curr = 0;
        for(int i=3;i<=n;i++){
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
}
