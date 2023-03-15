class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int count=0;
        int prod=1;
        int start=0;
        
        for(int i=0;i<arr.length;i++){
            prod=prod*arr[i];
            while(start<=i && prod>=k){
                prod=prod/arr[start];
                start++;
            }
            count+=i-start+1;
        }
        return count;
    }
}