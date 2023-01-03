class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        Set<Integer> nodes = new HashSet<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            List<Integer> startList;
            if (graph.containsKey(start)) {
                startList = graph.get(start);
            } else {
                startList = new ArrayList<>();
            }
            startList.add(end);
            graph.put(start, startList);
            List<Integer> endList;
            if (graph.containsKey(end)) {
                endList = graph.get(end);
            } else {
                endList = new ArrayList<>();
            }
            endList.add(start);
            graph.put(end, endList);
            nodes.add(start);
            nodes.add(end);
        }
        List<Integer> path = new ArrayList<>();
        findPathFromBobToZero(graph, bob, path, new HashSet<>());
        int[] distancesFromBob = new int[nodes.size()];
        int[] distancesFromZero = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            distancesFromBob[i] = -1;
            distancesFromZero[i] = -1;
        }
        calculateDistances(path, distancesFromBob, distancesFromZero);
        return calculateMaxPath(graph, 0, amount[0], new HashSet<Integer>(), distancesFromBob, distancesFromZero, amount);
    }
    public List<Integer> findPathFromBobToZero(Map<Integer, List<Integer>> graph, int currentNode, List<Integer> list, Set<Integer> visited) {
        if (!graph.containsKey(currentNode) || visited.contains(currentNode)) {
            return null;
        }
        if (currentNode == 0) {
            list.add(currentNode);
            return list;
        }
        visited.add(currentNode);
        List<Integer> neighbors = graph.get(currentNode);
        for (int neighbor : neighbors) {
            list.add(currentNode);
            List<Integer> result = findPathFromBobToZero(graph, neighbor, list, visited);
            if (result != null) {
                return result;
            }
            list.remove(list.size() - 1);
        }
        return null;        
    }
    public int calculateMaxPath(Map<Integer, List<Integer>> graph, int currentNode, int totalSum, Set<Integer> visited, int[] distancesFromBob, int[] distancesFromZero, int[] amount) {
        if (!graph.containsKey(currentNode) || visited.contains(currentNode)) {
            return Integer.MIN_VALUE;
        }   
        visited.add(currentNode);
        if (graph.get(currentNode).size() == 1 && currentNode != 0) {
            return totalSum;
        }
        List<Integer> neighbors = graph.get(currentNode);
        int maxSum = Integer.MIN_VALUE;
        for (int neighbor : neighbors) {
            int sumForNeighbor;
            if (distancesFromBob[neighbor] == -1 && distancesFromZero[neighbor] == -1) {
                sumForNeighbor = amount[neighbor];
            } else if (distancesFromBob[neighbor] == distancesFromZero[neighbor]) {
                sumForNeighbor = amount[neighbor] / 2;
            } else if (distancesFromBob[neighbor] > distancesFromZero[neighbor]) {
                sumForNeighbor = amount[neighbor];
            } else {
                sumForNeighbor = 0;
            }
            int result = calculateMaxPath(graph, neighbor, totalSum + sumForNeighbor, visited, distancesFromBob, distancesFromZero, amount);
            maxSum = Math.max(maxSum, result);
        }
        return maxSum;
    }
    public void calculateDistances(List<Integer> path, int[] distancesFromStart, int[] distancesFromEnd) {
        int currentDistanceFromStart = 0;
        for (int i = 0; i < path.size(); i++) {
            int node = path.get(i);
            distancesFromStart[node] = currentDistanceFromStart;
            currentDistanceFromStart++;
        } 
        int currentDistanceFromEnd = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            int node = path.get(i);
            distancesFromEnd[node] = currentDistanceFromEnd;
            currentDistanceFromEnd++;
        } 
    }
}