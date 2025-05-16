package leetcode.medium;

/*
 * 
152. Maximum Product Subarray
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
Constraints:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 */
public class Medium_152 {
	
	public static int maxProduct(int[] nums) {

		if (nums.length == 0)
			return 0;

		int maxSoFar = nums[0];
		int maxEndingHere = nums[0];
		int minEndingHere = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int curr = nums[i];

			// When multiplied by a negative number, max becomes min and vice versa
			if (curr < 0) {
				int temp = maxEndingHere;
				maxEndingHere = minEndingHere;
				minEndingHere = temp;
			}

			// Extend or start fresh from current number
			maxEndingHere = Math.max(curr, maxEndingHere * curr);
			minEndingHere = Math.min(curr, minEndingHere * curr);

			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}

		return maxSoFar;

	}

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 })); // Output: 6
		System.out.println(maxProduct(new int[] { -2, 0, -1 })); // Output: 0
		System.out.println(maxProduct(new int[] { -2, 3, -4 })); // Output: 24
	}

}
