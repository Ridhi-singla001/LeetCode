class Solution{
    public int findKthPositive(int[] arr, int k) {
    int lo = 0, hi = arr.length;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] - mid > k) hi = mid;
        else lo = mid + 1;
    }
    return lo + k;
    }
}