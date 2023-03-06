public class Solution {
    public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
        
    int[] ch = new int[256];
        
    for(int i = 0; i < s.length(); i++) {
        ch[s.charAt(i)]++;
    }

    for(int i = 0; i < t.length(); i++) {
        ch[t.charAt(i)]--;
        if(ch[t.charAt(i)] < 0) {
            return false;
        }
    }

    return true;

}
}