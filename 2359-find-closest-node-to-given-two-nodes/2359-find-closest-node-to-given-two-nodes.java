class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int [] arr1 = new int[n];
        int [] arr2 = new int[n];
        int curr = node1;
        int dist = 0;
        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);
        while(curr!=-1 && arr1[curr]==-1){
            arr1[curr] = dist;
            curr = edges[curr];
            dist++;    
        }
        dist = 0;
        curr = node2;
        int min = Integer.MAX_VALUE/10;
        int result = -1;
        int max;
        while(curr!=-1 && arr2[curr]==-1){
            arr2[curr] = dist;
            if(arr1[curr]!=-1){
                 max = Math.max(arr1[curr], arr2[curr]);
                 if(max<min){
                    result = curr;
                    min = max;
                }else if(max == min){
                    if(result>curr) result = curr;
                }
            }
            curr = edges[curr];
            dist++;
        }
        return result;
    }
}