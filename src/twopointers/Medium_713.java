package twopointers;

import java.util.ArrayList;
import java.util.List;

/*
 * 713. Subarray Product Less Than K
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
Example 1:
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:
Input: nums = [1,2,3], k = 0
Output: 0
Constraints:
1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106
 */

public class Medium_713 {

	public static List<List<Integer>> findSubarrays(int[] nums, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (k <= 1)
			return result; // If k <= 1, no valid subarrays exist

		int product = 1, left = 0;

		for (int right = 0; right < nums.length; right++) {
			product *= nums[right];

			// Shrink the window if the product becomes >= k
			while (product >= k && left <= right) {
				product /= nums[left++];
			}

			// Add all valid subarrays ending at `right`
			List<Integer> tempList = new ArrayList<>();
			for (int i = right; i >= left; i--) {
				tempList.add(0, nums[i]); // Insert at the beginning
				result.add(new ArrayList<>(tempList));
			}
		}
		return result;
	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}
		int product = 1;
		int count = 0;
		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			product *= nums[right];
			while (product >= k) {
				product /= nums[left++];
			}
			count += right - left + 1;
		}
		return count;
	}

	public static void main(String[] args) {
		// to get the subarrays
		System.out.println(findSubarrays(new int[] {2, 5, 3, 10}, 30)); //[2], [5], [2, 5], [3], [5, 3], [10] There are six contiguous subarrays whose product is less than the target.
		System.out.println(findSubarrays(new int[] {8, 2, 6, 5}, 50)); //[8], [2], [8, 2], [6], [2, 6], [5], [6, 5] There are seven contiguous subarrays whose product is less than the target.
		System.out.println(findSubarrays(new int[] { 10, 5, 2, 6 }, 100)); //The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
		// to get the subarrays count
		System.out.println(numSubarrayProductLessThanK(new int[] {2, 5, 3, 10}, 30));
		System.out.println(numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
		System.out.println(numSubarrayProductLessThanK(new int[] {8, 2, 6, 5}, 50));

		
	}

}
