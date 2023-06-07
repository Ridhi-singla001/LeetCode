class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return solve(0,1,arr,dp);
    }
    public static int solve(int ind, int buy, int arr[], int dp[][]){
        int n=arr.length;
        int profit=0;
        if(ind==n) return 0;
        
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1){
            profit=Math.max(-arr[ind]+solve(ind+1,0,arr,dp),solve(ind+1,1,arr,dp));
        }else{
            profit=Math.max(arr[ind]+solve(ind+1,1,arr,dp),0+solve(ind+1,0,arr,dp));
        }
        return dp[ind][buy]=profit;
    }
}