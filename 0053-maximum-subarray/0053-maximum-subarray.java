class Solution {
    public int maxSubArray(int[] arr) {
        int n=arr.length;
        int currSum=0;
        int maxSum=arr[0];
        
        for(int i=0;i<n;i++){
            currSum=currSum+arr[i];
            if(currSum>maxSum){
                maxSum=currSum;
            }
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }
}