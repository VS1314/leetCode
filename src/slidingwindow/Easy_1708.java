package slidingwindow;

/*
 * 1708. largest subarray length k
 * Given an array of positive numbers and a positive number K, find the maximum sum of any contiguous subarray of size K.
 * 
 * maxSubarrayOfSizeK([2, 1, 5, 1, 3, 2], 3)//9 
   maxSubarrayOfSizeK([2, 3, 4, 1, 5], 2)//7 
 */

public class Easy_1708 {

	public static int maxSubarrayOfSizeK(int[] nums, int k) {
		int start = 0;
		int sum = 0;
		int maxSum = 0;
		for (int end = 0; end < nums.length; end++) {
			sum += nums[end];
			if (end >= k - 1) {
				maxSum = Math.max(sum, maxSum);
				sum -= nums[start];
				start++;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(maxSubarrayOfSizeK(new int[] { 2, 1, 5, 1, 3, 2 }, 3));// 9
		System.out.println(maxSubarrayOfSizeK(new int[] { 2, 3, 4, 1, 5 }, 2));// 7

	}

}
