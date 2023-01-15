class Solution {
     public int numberOfGoodPaths(int[] vals, int[][] edges) {
        //Space: O(N + N)
        List<List<Integer>> adjList = new ArrayList<>(); //graph 
        Map<Integer, List<Integer>> valueIdxMap = new TreeMap<>(); //value：nodeList

        //Time: O(N * lgN)
        for (int i = 0; i < vals.length; i++){
            List<Integer> nodeSet = valueIdxMap.getOrDefault(vals[i], new ArrayList<>());
            valueIdxMap.put(vals[i], nodeSet);
            nodeSet.add(i);

            adjList.add(new ArrayList<>());
        }

        //graph
        //Time: O(N)
        for (int[] edge : edges) {
			//smaller neighbors 
            if (vals[edge[1]] <= vals[edge[0]])
                adjList.get(edge[0]).add(edge[1]);
            else
                adjList.get(edge[1]).add(edge[0]);
        }

        int res = 0;
        //Time: O(N); Space: O(N)
        UnionFind uf = new UnionFind(vals.length);
        int[] count = new int[vals.length];

        //from smallest to largest
        for (int value : valueIdxMap.keySet()) {

            List<Integer> nodeSet = valueIdxMap.get(value);
            List<Integer> rootSet = new ArrayList<>(); 

            //reset count
            for (int idx : nodeSet) count[idx] = 1;

            //union
            for (Integer node : nodeSet)
                rootSet.add(uf.unionNeighbors(node, adjList.get(node), count));

            for (int node : rootSet) {
                res += (count[node] * (count[node] + 1) / 2);
//                res += (count[node] == 1) ? 1 : (count[node] * (count[node] + 1) / 2);
                count[node] = 0;
            }
        }
        return res;
    }

    class UnionFind {
        int[] data;
        int[] rank;

        //Time: O(N)
        public UnionFind(int n){
            data = new int[n];
            rank = new int[n];
            for (int i = 0 ; i < n; i++) {
                data[i] = i; rank[i] = 1;
            }
        }

        private int find(int node){
            while (data[node] != node) node = data[node];
            return data[node];
        }

		//union Neighbors(which are smaller than current node(node1)
		//and return node1's root.
        public int unionNeighbors(int node1, List<Integer> neighbors, int[] count) {
            int root1 = find(node1);

            for (Integer neighbor : neighbors) {
                int root2 = find(neighbor);
                if (root1 == root2) continue;

                if (rank[root1] < rank[root2]) {
                    data[root1] = root2;
					
                    count[root2] += count[root1];
                    count[root1] = 0;
					
                    root1 = root2; //update node1's root
					
                } else {
                    data[root2] = root1;
					
                    if (rank[root2] == rank[root1]) rank[root1]++;
					
                    count[root1] += count[root2];
                    count[root2] = 0;
                }
            }
            return root1;
        }
    }
}
