class Solution {
    public int numDistinct(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
         int dp[][]=new int[n][m];
         for(int rows[]: dp)
         Arrays.fill(rows,-1);
         return solve(s1,s2,n-1,m-1,dp);
    }
    
   public static int solve(String s1, String s2, int i, int j, int[][] dp){
     if(j<0) return 1;
    if(i<0) return 0;
    
    if(dp[i][j]!=-1) return dp[i][j];
    
    if(s1.charAt(i)==s2.charAt(j)){
        
        return dp[i][j] = solve(s1,s2,i-1,j-1,dp)+ solve(s1,s2,i-1,j,dp);
    } else{
        return dp[i][j] = solve(s1,s2,i-1,j,dp);
    }
  }
}