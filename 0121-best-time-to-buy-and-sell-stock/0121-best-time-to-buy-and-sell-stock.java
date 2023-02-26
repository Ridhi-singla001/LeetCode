class Solution {
    public int maxProfit(int[] arr) {
        int profit=0;
        int mini=arr[0];
        for(int i=1;i<arr.length;i++){
            int diff=arr[i]-mini;
            profit=Math.max(profit,diff);
            mini=Math.min(mini,arr[i]);
        }
        return profit;
    }
}