class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int origSum=(nums.size()*(nums.size()+1))/2; // sum of n natural numbers till size of nums=n*(n+1)/2
        int sum=0;// sum of our given array
        int x=0; // our repeated number 
		// Let y be our deleted number
        unordered_map<int,int> a;
        for(int e:nums){
           a[e]++;
           sum+=e;
           if(a[e]==2){
               x=e;
           }
        }
        return {x,origSum-sum+x}; // since (sum+y-x=origSum) therefore y=origSum-sum+x.
    }
};