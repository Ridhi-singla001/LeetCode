class Solution {
    public int mySqrt(int x) {
        long s=0;
        long e=x/2;
        long ans=0;
        if(x==1){
            return 1;
        }
        while(s<=e){
            long mid=(s+e)/2;
            if(mid*mid==x){
                return (int)mid;
            }else if(mid*mid>x){
                e=mid-1;
            }else{
                ans=mid;
                s=mid+1;
            }
        }
        return (int)ans;
    }
}