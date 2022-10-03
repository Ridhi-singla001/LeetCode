class Solution {
public:
    int minCost(string colors, vector<int> &neededTime)
    {
        auto N = colors.size();
        int ans = 0;
        int i = 0;
        int j;
        bool flag;
        int curr;
        int mx;
        while (i < N)
        {
            j = i + 1;
            flag = false;
            curr = neededTime[i];
            mx = curr;
            while (j < N && colors[i] == colors[j])
            {
                mx = max(mx, neededTime[j]);
                curr += neededTime[j];
                ++j;
                flag = true;
            }

            if (flag)
            {
                ans += (curr - mx);
            }
            i = j;
        }
        return ans;
    }
};