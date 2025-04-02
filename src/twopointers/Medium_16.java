package twopointers;

import java.util.Arrays;

/*
 * 16. 3Sum Closest
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
Constraints:
3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
 */

public class Medium_16 {

	public static int threeSumClosest(int[] nums, int target) {
		int threeSumClosest = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int currentSum = nums[i] + nums[start] + nums[end];
				if (currentSum == target) {
					return currentSum;
				}
				if (Math.abs(target - currentSum) < Math.abs(target - threeSumClosest)) {
					threeSumClosest = currentSum;
				}
				if (currentSum < target) {
					start++;
				} else {
					end--;
				}
			}
		}
		return threeSumClosest;
	}

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { -2, 0, 1, 2 }, 2));// 1, he triplet [-2, 1, 2] has the closest
																			// sum to the target.
		System.out.println(threeSumClosest(new int[] { -3, -1, 1, 2 }, 1));// 0, The triplet [-3, 1, 2] has the closest
																			// sum to the target.
		System.out.println(threeSumClosest(new int[] { 1, 0, 1, 1 }, 100));// 3, The triplet [1, 1, 1] has the closest
																			// sum to the target.
		System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));// 2, The sum that is closest to the target
																			// is 2. (-1 + 2 + 1 = 2).

	}

}
