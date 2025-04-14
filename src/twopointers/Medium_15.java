package twopointers;
/*
 * 15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_15 {

	public static List<List<Integer>> searchTriplets(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		Arrays.sort(nums);//[-3, -2, -1, 0, 1, 1, 2]
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			searchPair(nums, -nums[i], i + 1, output);
		}
		return output;
	}

	private static void searchPair(int[] nums, int target, int start, List<List<Integer>> output) {
		int end = nums.length - 1;
		while (start < end) {
			int currentSum = nums[start] + nums[end];
			if (target == currentSum) {
				output.add(Arrays.asList(-target, nums[start], nums[end]));
				start++;
				end--;
				while (start < end && nums[start] == nums[start - 1]) {
					start++;
				}
				while (start < end && nums[end] == nums[end + 1]) {
					end--;
				}
			} else if (currentSum < target) {
				start++;
			} else {
				end--;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { -3, 0, 1, 2, -1, 1, -2 };
		System.out.println(Medium_15.searchTriplets(nums));
	}

}
