class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int num : nums) {
            hashSet.add(num);
        }
        
        int maxCount=0;
        //O(n)
        for(int num:nums){
            if(!hashSet.contains(num-1)){
                int currNum=num;
                int currCount=1;
                
                while(hashSet.contains(currNum+1)){
                    currNum+=1;
                    currCount+=1;
                }
                
                maxCount=Math.max(maxCount,currCount);       
            }
        }
        return maxCount;
    }
}