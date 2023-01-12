class Solution {
    public int minimumCardPickup(int[] cards) {
        int[] lastIdx = new int[1000001];
        Arrays.fill(lastIdx, -1);
        
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < cards.length; i++) {
            if (lastIdx[cards[i]] != -1) {
                minLen = Math.min(minLen, i - lastIdx[cards[i]] + 1);
            }
            
            lastIdx[cards[i]] = i;
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}