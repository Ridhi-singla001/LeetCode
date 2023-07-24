import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int tar) {
        Arrays.sort(nums);
        long target = tar;
        List<List<Integer>> l = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long t = target - nums[i] - nums[j];
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int tt = nums[left] + nums[right];
                    if (tt < t) {
                        left++;
                    } else if (tt > t) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        l.add(list);
                        while (left < right && nums[left] == list.get(2)) left++;
                        while (left < right && nums[right] == list.get(3)) right--;
                    }
                }
            }
        }
        return l;
    }
}