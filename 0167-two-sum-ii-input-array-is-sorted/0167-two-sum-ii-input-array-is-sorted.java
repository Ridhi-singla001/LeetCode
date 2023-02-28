class Solution {
    public int[] twoSum(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        int ans[]=new int[2];
        
        while(start<end){
            if(arr[start]+arr[end]==target){
                ans[0]=start+1;
                ans[1]=end+1;
                return ans;
            }else if(arr[start]+arr[end]<target){
                start++;
            }else{
                end--;
            }
        }
        return null;
    }
}