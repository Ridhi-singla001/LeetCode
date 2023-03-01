class Solution {
    public int countPrimes(int n) {
        if(n==0 || n==1){
            return 0;
        }
        int count =0;
        boolean arr[]=new boolean[n];
        arr[0]=true;
        arr[1]=true;
        
        for(int i=2;i*i<=n;i++){
            if(arr[i]==false){
                for(int mul=2;i*mul<n;mul++){
                    arr[i*mul]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]==false){
                count++;
            }
        }
        return count;
    }
}