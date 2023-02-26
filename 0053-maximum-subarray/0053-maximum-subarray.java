class Solution {
    public int maxSubArray(int[] arr) {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(maxi<arr[i]){
                maxi= arr[i];
            }
        }
        int currSum=0;
        for(int i=0;i<arr.length;i++){
            currSum=currSum+arr[i];
            if(currSum>maxi){
                maxi=currSum;
            }
            if(currSum<0){
                currSum=0;
            }
        }
        return maxi;
    }
}