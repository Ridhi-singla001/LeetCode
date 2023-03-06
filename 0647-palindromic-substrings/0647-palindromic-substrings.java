class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
            for(int j=i+1;j<=s.length();j++)
                if(isPalindrome(s.substring(i,j)))
                    count++;
                
        return count;
    }
    
    private boolean isPalindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<=r && s.charAt(l)==s.charAt(r)){
            l++;
            r--;
        }
        return l>=r;
    }
}