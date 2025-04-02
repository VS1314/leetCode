package slidingwindow;

/*
 * 209. Minimum Size Subarray Sum
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */

public class Medium_209 {

	public static int minSubArrayLen(int target, int[] nums) {
		int minSubArrayLen = Integer.MAX_VALUE;
		int start = 0;
		int sum = 0;
		for (int end = 0; end < nums.length; end++) {
			sum += nums[end];
			while (sum >= target) {
				minSubArrayLen = Math.min(minSubArrayLen, end - start + 1);
				sum -= nums[start];
				start++;
			}
		}
		if (minSubArrayLen == Integer.MAX_VALUE) {
			return 0;
		}
		return minSubArrayLen;
	}

//	public static int minSubArrayLen(int target, int[] nums) {
//		int n = nums.length;
//		int[] prefix = new int[n + 1]; // Prefix sum array
//
//		// Compute prefix sums
//		for (int i = 1; i <= n; i++) {
//			prefix[i] = prefix[i - 1] + nums[i - 1];
//		}
//
//		int minLen = Integer.MAX_VALUE;
//
//		// For each end index, use binary search to find the start index
//		for (int end = 1; end <= n; end++) {
//			int requiredSum = prefix[end] - target;
//			int start = binarySearch(prefix, requiredSum);
//			if (start != -1) {
//				minLen = Math.min(minLen, end - start + 1);
//			}
//		}
//
//		return minLen == Integer.MAX_VALUE ? 0 : minLen;
//	}
//
//	private static int binarySearch(int[] prefix, int target) {
//		int low = 0, high = prefix.length - 1;
//
//		while (low <= high) {
//			int mid = low + (high - low) / 2;
//
//			if (prefix[mid] <= target) {
//				low = mid + 1; // Move right
//			} else {
//				high = mid - 1; // Move left
//			}
//		}
//
//		// Return the smallest index with prefix sum > target
//		return low < prefix.length ? low : -1;
//	}

	public static void main(String[] args) {
		int target = 7;
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int target1 = 4;
		int[] nums1 = { 1, 4, 4 };
		int target2 = 11;
		int[] nums2 = { 1, 1, 1, 1, 1, 1, 1, 1 };

		System.out.println(Medium_209.minSubArrayLen(target2, nums2));
	}

}
