class Solution {
    public int climbStairs(int n) {
        int arr[]=new int[n+1];
        Arrays.fill(arr,-1);
        return sol(n,arr);
    }
    public int sol(int n,int arr[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(arr[n]!=-1){
            return arr[n];
        }
        arr[n]=sol(n-1,arr)+sol(n-2,arr);
        return arr[n];
    }
}