class Solution {
    public List<List<String>> partition(String s) {
        // backtracking 
        // 1. define `ans` to hold `candidates`
        List<List<String>> ans = new ArrayList<>();
        // 2. define `candidates` to hold all potential candidates (palindromic substring)
        List<String> candidates = new ArrayList<>();
        // 3. start backtrack from index 0
        backtrack(s, ans, candidates, 0);
        // 4. return ans
        return ans;
    }
    
    private void backtrack(String s, List<List<String>> ans, List<String> candidates, int start) {
        // 1. check if the goal is fulfilled, 
        // i.e. reaching the end of string in this problem
        if (start == s.length()) {
            ans.add(new ArrayList<>(candidates));
            return;
        }
        // 2. find all potential candidates
        for (int i = start; i < s.length(); i++) {
            // we want to test all substrings, each substring is a potential candidate
            // e.g. "aab" -> "a", "a", "b", "ab", "aa", "b", "aab"
            String candidate = s.substring(start, i + 1);
            // 3. check if the current candidate is palindrome or not 
            // if not, then we cannot push to `candidates`
            if (!isPalindrome(candidate)) continue;
            // 4. if so, push it to candidates
            candidates.add(candidate);
            // 5. backtrack with index + 1
            backtrack(s, ans, candidates, i + 1);
            // 6. remove the current substring from `candidates`
            candidates.remove(candidates.size() - 1);
        }
    }
    
    // there are different ways to check if `s` is palindrome 
    // here's one of the ways
    private boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}