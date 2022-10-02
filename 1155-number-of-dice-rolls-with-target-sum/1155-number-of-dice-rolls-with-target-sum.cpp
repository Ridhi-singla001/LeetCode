class Solution {
    vector<vector<int>> dp;
public:
    int roll(int i, int k, int target){
        if(dp[i][target] != -1)// memorization
            return dp[i][target];
        if(target>i*k || target<i)// if target is unachievable
            return dp[i][target]=0;
        
        int mod = 1e9 + 7;
        long ans=0;
        for(int j=1; j<=k; j++){// check for every outcome of current dice
            if(target-j < i-1)break; // if target becomes less than number of dices left we can't achieve it
            ans += roll(i-1, k, target-j);
            ans %= mod;
        }
        
        return dp[i][target]=ans%mod;
    }
    int numRollsToTarget(int n, int k, int target) {
        if(target > n*k)return 0;
        dp.resize(n+1, vector<int>(target+1, -1));
        dp[0][0]=1; // target 0 with 0 dices left has only one possibility
        return roll(n, k, target);
    }
};