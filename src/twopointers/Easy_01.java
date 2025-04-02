package twopointers;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 */
public class Easy_01 {

	public static int[] twoSum(int[] nums, int target) {
		// Create a hash map to store numbers and their indices
		HashMap<Integer, Integer> numToIndex = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (numToIndex.containsKey(complement)) {
				// If the complement is in the hash map, return its index and the current index
				return new int[] { numToIndex.get(complement), i };
			}
			// Otherwise, store the current number and its index in the hash map
			numToIndex.put(nums[i], i);
		}

		// If no solution is found, return an empty array
		return new int[] { -1, -1 };
	}

	public static int[] twoSumTwoPointers(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int sum = nums[start] + nums[end];
			if (sum == target) {
				return new int[] { nums[start], nums[end] };
			} else if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(Easy_01.twoSum(nums, 9)));
		System.out.println(Arrays.toString(Easy_01.twoSumTwoPointers(nums, 9)));
	}

}
