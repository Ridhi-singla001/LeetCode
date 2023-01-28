class SummaryRanges {

   private TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>(); 
    }
    
    public void addNum(int value) {
        final Map.Entry<Integer, Integer> minEntry = intervals.floorEntry(value); 
        int left = value, right = value;
        if (minEntry != null) {
            int rightEntry = minEntry.getValue();
            if (rightEntry >= value) {
                return;
            }
            if (rightEntry == value - 1) {
                left = minEntry.getKey();
            }
        }
        final Map.Entry<Integer, Integer> maxEntry = intervals.higherEntry(value); 
        if (maxEntry != null && maxEntry.getKey() == value + 1) {
            right = maxEntry.getValue();
            intervals.remove(value + 1);
        }
        intervals.put(left, right);
    }
    
    public int[][] getIntervals() {
        final int[][] answer = new int[intervals.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            answer[i][0] = entry.getKey();
            answer[i][1] = entry.getValue();
            i++;
        }
        return answer; 
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */