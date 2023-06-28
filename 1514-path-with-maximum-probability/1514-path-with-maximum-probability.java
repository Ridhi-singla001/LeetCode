class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        int [] edge;
        for(int  i = 0;i< edges.length;i++){
            edge = edges[i];
            graph.computeIfAbsent(edge[0],k->new ArrayList<>()).add(new Pair<>(edge[1],succProb[i]));
            graph.computeIfAbsent(edge[1],k->new ArrayList<>()).add(new Pair<>(edge[0],succProb[i]));
        }
        //System.out.println(graph);
        double [] maxProb = new double[n];
        maxProb[start] = 1.0;
        
        PriorityQueue<Pair<Integer,Double>> pq = new PriorityQueue<>((a,b)->-Double.compare(a.getValue(),b.getValue()));
        pq.add(new Pair<>(start,1.0));
        while (!pq.isEmpty()){
            
            Pair<Integer,Double> curr = pq.remove();
            if(curr.getKey()==end)return curr.getValue();
            for(Pair<Integer,Double> path: graph.getOrDefault(curr.getKey(),new ArrayList<>())){
                if(curr.getValue()* path.getValue()>maxProb[path.getKey()]){
                    maxProb[path.getKey()] = (double)curr.getValue()* path.getValue();
                    pq.add(new Pair<>(path.getKey(), maxProb[path.getKey()]));
                }
            }
        }
        return 0.0;
    }
}