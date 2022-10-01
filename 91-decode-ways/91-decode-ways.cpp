#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    int n;
    map<string, int> mp;
    vector<int> dp;
    int solve(string &s, int i)
    {
        if (i <= n - 1)
        {
            string curr1 = to_string(s[i] - '0');
            if (mp.find(curr1) == mp.end())
                return 0;
        }
        if (i >= n - 1)
            return 1;
        if (dp[i] != -1)
            return dp[i];
        int ans1 = 0, ans2 = 0;
        string curr1 = to_string(s[i] - '0');
        if (mp.find(curr1) == mp.end())
            return 0;
        if (mp.find(curr1) != mp.end())
            ans1 += solve(s, i + 1);
        if (i + 1 < n)
        {
            string curr2 = to_string(s[i] - '0') + to_string(s[i + 1] - '0');
            if (mp.find(curr2) != mp.end())
                ans2 += solve(s, i + 2);
        }
        return dp[i] = ans1 + ans2;
    }
    int numDecodings(string s)
    {
        n = s.size();
        dp = vector<int>(n + 1, -1);
        for (int i = 1; i <= 26; i++)
        {
            string curr = to_string(i);
            mp[curr]++;
        }
        if (n == 1)
        {
            string curr1 = to_string(s[0] - '0');
            if (mp.find(curr1) == mp.end())
                return 0;
        }
        return solve(s, 0);
    }
};