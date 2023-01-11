class Solution 
{
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) 
    {
        List<Integer>[] canVisit = new ArrayList[n];
        
        //Creating adjacency list
        for(int i = 0; i<n; i++)
        {
            canVisit[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            canVisit[edge[0]].add(edge[1]);            
            canVisit[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        return helper(0,hasApple,canVisit,visited);
        
    }
    int helper(int i, List<Boolean> hasApple, List<Integer>[] canVisit, boolean[] visited)
    {
        if(visited[i]) return 0;
        visited[i] = true;
        
        // Visiting every child node
        int sum = 0;
        for(int edge : canVisit[i])
        {
            sum += helper(edge, hasApple, canVisit, visited);
        }
        
        if(i==0) return  sum; // Special case for the root node
        
        // If any children contain an apple or the current node contains an apple we return (2+sum)
        if(hasApple.get(i) || sum>0 ) return (2 + sum); 
        
        //If neither the children or the current node contain an apple we just return 0
        else return 0;        
    }
}