package slidingwindow;

/*
 * 1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 
Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */
public class Medium_1004 {

	public static int longestOnes(int[] nums, int k) {
		int longestOnes = 0;
		int start = 0;
		int zeros = 0;
		for (int end = 0; end < nums.length; end++) {
			if (nums[end] == 0) {
				zeros++;
			}
			while (zeros > k) {
				if (nums[start] == 0) {
					zeros--;
				}
				start++;
			}
			longestOnes = Math.max(longestOnes, end - start + 1);
		}
		return longestOnes;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;
		int[] nums1 = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		int k1 = 3;
		int[] nums2 = { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 };
		int k2 = 2;
		int[] nums3 = { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 };
		int k3 = 3;
		System.out.println(longestOnes(nums3, k3));
	}

}
