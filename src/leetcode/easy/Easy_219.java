package leetcode.easy;

import java.util.HashMap;

/*
 * 
219. Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */

public class Easy_219 {

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			} else {
				if (i - map.get(nums[i]) <= k) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 1 };
		int[] nums2 = { 1, 0, 1, 1 };
		int[] nums3 = { 1, 2, 3, 1, 2, 3 };
		int k1 = 3;
		int k2 = 1;
		int k3 = 2;
		System.out.println(containsNearbyDuplicate(nums3, k3));
	}

}
