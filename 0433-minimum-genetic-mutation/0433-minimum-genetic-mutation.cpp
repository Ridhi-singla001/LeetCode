class Solution {
public:
    
    int minMutation(string start, string end, vector<string>& bank) {
        
        queue<string> q;
        unordered_map<string, int> vis;
        int steps = 0;
        q.push(start);
        vis[start] = 1;
        while (!q.empty()) { 
            for (int i = q.size(); i > 0; i--) {
                string s = q.front();
                q.pop();
                if (s == end) return steps;
                for (int j = 0; j < 8; j++) {
                    char oc = s[j];
                    for (int k = 0; k < 4; k++) {
                        s[j] = "ACGT"[k];
                        if (!vis[s] && find(bank.begin(), bank.end(), s) != bank.end()) {
                            q.push(s);
                            vis[s] = 1;
                        }
                    }
                    s[j] = oc;
                }
            }
            steps += 1;
        }
        return -1;
    }
};