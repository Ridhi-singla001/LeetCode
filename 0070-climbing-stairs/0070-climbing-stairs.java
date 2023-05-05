class Solution {
    public int climbStairs(int n) {
        // if(n==0 || n==1){
        //     return 1;
        // }
        // return climbStairs(n-1)+climbStairs(n-2);
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return func(n,dp);
    }
    public static int func(int n, int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=-1) return dp[n];
        
        return dp[n]=func(n-1,dp)+func(n-2,dp);
    }
}