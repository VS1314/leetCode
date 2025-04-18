package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 18. 4Sum
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
Constraints:
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */
public class Medium_18 {

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				searchPairs(nums, target, i, j, result);
			}
		}
		return result;
	}

	private static void searchPairs(int[] nums, int target, int first, int second, List<List<Integer>> result) {
		int start = second + 1;
		int end = nums.length - 1;
		while (start < end) {
			long sum = (long) (nums[first] + nums[second] + nums[start] + nums[end]);
			if (sum == target) {
				result.add(Arrays.asList(nums[first], nums[second], nums[start], nums[end]));
				start++;
				end--;
				while (start < end && nums[start] == nums[start - 1]) {
					start++;
				}
				while (start < end && nums[end] == nums[end + 1]) {
					end--;
				}
			} else if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(fourSum(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
		System.out.println(fourSum(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
		System.out.println(fourSum(new int[] { -1, 0, -5, -2, -2, -4, 0, 1, -2 }, -9));
		System.out.println(fourSum(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, -294967296));

	}

}
