class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
	var dp = new int[nums.length];
	return constructLDS(nums, dp, getLDSSize(nums, dp));
}

private int getLDSSize(int[] nums, int[] dp) {
	Arrays.sort(nums);
	Arrays.fill(dp, 1);
	var ldsSize = 1;

	for (var i = 1; i < nums.length; i++)
		for (var j = 0; j < i; j++)
			if (nums[i] % nums[j] == 0) {
				dp[i] = Math.max(dp[i], dp[j] + 1);
				ldsSize = Math.max(ldsSize, dp[i]);
			}
			
	return ldsSize;
}

private List<Integer> constructLDS(int[] nums, int[] dp, int ldsSize) {
	var prev = -1;
	var lds = new LinkedList<Integer>();

	for (var i = dp.length - 1; i >= 0; i--)
		if (dp[i] == ldsSize && (prev == -1 || prev % nums[i] == 0)) {
			lds.addFirst(nums[i]);
			ldsSize--;
			prev = nums[i];
		}

	return lds;
}
}