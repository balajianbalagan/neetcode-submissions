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
        int[] dp = new int[n+1];
        return rec(n,dp);
    }
}