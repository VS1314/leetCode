package cyclicsort;

/*
 * 41. First Missing Positive
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
Example 1:
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
 */
public class Hard_41 {

	public static int firstMissingPositive(int[] nums) {

		int i = 0;
		while (i < nums.length) {
			int j = nums[i] - 1;
			if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[j]) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			} else {
				i++;
			}
		}
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] { -3, 1, 5, 4, 2 }));
		System.out.println(firstMissingPositive(new int[] { 3, -2, 0, 1, 2 }));
		System.out.println(firstMissingPositive(new int[] { 3, 2, 5, 1 }));
		System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}

}
