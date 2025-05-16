package leetcode.medium;

/*
53. Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Medium_53 {

	public static int maxSubArray(int[] nums) {// O(n)

		int maxSoFar = nums[0];
		int currentSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			// Either extend the current subarray or start a new one
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			maxSoFar = Math.max(maxSoFar, currentSum);
		}

		return maxSoFar;
	}

	public static int maxSubArray1(int[] nums) {
		return divideAndConquer(nums, 0, nums.length - 1);
	}

	private static int divideAndConquer(int[] nums, int left, int right) {
		if (left == right)
			return nums[left]; // Base case: one element

		int mid = (left + right) / 2;

		int leftSum = divideAndConquer(nums, left, mid);
		int rightSum = divideAndConquer(nums, mid + 1, right);
		int crossSum = maxCrossingSum(nums, left, mid, right);

		return Math.max(Math.max(leftSum, rightSum), crossSum);
	}

	private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
		int leftMax = Integer.MIN_VALUE, sum = 0;
		for (int i = mid; i >= left; i--) {
			sum += nums[i];
			leftMax = Math.max(leftMax, sum);
		}

		int rightMax = Integer.MIN_VALUE;
		sum = 0;
		for (int i = mid + 1; i <= right; i++) {
			sum += nums[i];
			rightMax = Math.max(rightMax, sum);
		}

		return leftMax + rightMax;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })); // 6
		System.out.println(maxSubArray(new int[] { 1 })); // 1
		System.out.println(maxSubArray(new int[] { 5, 4, -1, 7, 8 })); // 23
		System.out.println(maxSubArray1(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })); // 6
		System.out.println(maxSubArray1(new int[] { 1 })); // 1
		System.out.println(maxSubArray1(new int[] { 5, 4, -1, 7, 8 })); // 23
	}

}
