package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_15 {

	public static List<List<Integer>> searchTriplets(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		Arrays.sort(nums);
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
