package twopointers;

import java.util.Arrays;

/*
 * 75. Sort Colors
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class Medium_75 {

	public static void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int i = 0;
		while (i <= right) {
			if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[left];
				nums[left] = temp;
				i++;
				left++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				int temp = nums[i];
				nums[i] = nums[right];
				nums[right] = temp;
				right--;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		sortColors(new int[] { 2, 1, 2, 0, 1, 0 });
		
	}

}
