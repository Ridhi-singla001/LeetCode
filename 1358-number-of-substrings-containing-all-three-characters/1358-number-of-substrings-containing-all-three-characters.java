class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), count = 0;
        int l1 = -1, l2 = -1, l3 = -1;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a') l1 = i;
            else if(s.charAt(i) == 'b') l2 = i;
            else l3 = i;
            if(l1 == -1 || l2 == -1 || l3 == -1) continue;
            int min = Math.min(l1, Math.min(l2, l3));
            count += min + 1;
        }
        return count;
    }
}