class Solution {
   public int countPaths(int n, int[][] roads) {
        long [][]dp = new long[n][2];
        ArrayList<long []> []graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList();
        }
        for(int []road: roads){
            int src = road[0];
            int dest = road[1];
            int dist = road[2];
            graph[src].add(new long[]{dest, dist});
            graph[dest].add(new long []{src, dist});
        }
        PriorityQueue<long []> pq = new PriorityQueue<long []>((a,b) -> Long.compare(a[2], b[2]));
        for(int i=1;i<n;i++){
            dp[i][0] = Long.MAX_VALUE;
        }
        dp[0][1] = 1;
        for(int i=0;i<graph[0].size();i++){
            long []tmp = graph[0].get(i);
            pq.add(new long[]{0, tmp[0], tmp[1]});
        }
        long mod = 1000000007;
        while(pq.size() > 0){
            long []poll = pq.poll();
            int src = (int)poll[0];
            int dest = (int)poll[1];
            long dist = poll[2];
            if(dist <= dp[dest][0]){
                dp[dest][1] = (dp[dest][1] + dp[src][1])%mod;
            }
            if(dist < dp[dest][0]){
                dp[dest][0] = dist;
                for(int i=0;i<graph[dest].size();i++){
                    long []tmp = graph[dest].get(i);
                    pq.add(new long[]{dest, tmp[0], tmp[1] + dp[dest][0]});
                }
            }
        }
        return (int)(dp[n-1][1] % mod);
    }
}