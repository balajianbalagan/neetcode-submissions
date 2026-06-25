class Solution {
    public int rec(int i,int[] dp){
        if(dp[i]!=0){
            return dp[i];
        }
        if(i==2){
            return 1;
        }
        if(i<2){
            return i;
        }
        dp[i] = rec(i-1,dp) + rec(i-2,dp) + rec(i-3,dp);
        return dp[i];
    }
    public int tribonacci(int n) {
        // int prev = 1;
        // int prev1 = 1;
        // int prev2 = 0;

        /*


        */
        // int[] dp = new int[n+1];
        if(n<=2){
            if(n==0)return n;
            return 1;
        }
        int prev3 = 0;
        int prev1 = 1;
        int prev2 = 1;
        int curr = 0;
        for(int i=3;i<=n;i++){
            curr = prev1 + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
            // dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }


        return curr;
    }
}