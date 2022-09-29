class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> closest;
        for(int i = 0; i < arr.size() ; i++)
        {
            closest.push_back(abs(x-arr[i]));
        }
        vector<int> ans;
        int min = 10001;
        int minIndex = 0;
        for(int i = 0; i < arr.size() ; i++)
        {
            if (closest[i] < min)
            {
                min = closest[i];
                minIndex = i;
            }
        }
        int p = minIndex - 1;
        int q = minIndex + 1;
        int startIndex = minIndex;
        int re = k; 
        while(--k!=0)
        {
            if (p < 0)
            {
                startIndex = p + 1;
                break;
            }
            if (q == arr.size())
            {
                startIndex = q - re;
                break;
            }
            if (closest[p] <= closest[q])
            {
                startIndex = p--;
            }
            else
            {
                q++;
            }
        }
        while(re--)
        {
            ans.push_back(arr[startIndex++]);
        }
        return ans;
    }
    
};