package cyclicsort;

/*
 * 448. Find All Numbers Disappeared in an Array
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:
Input: nums = [1,1]
Output: [2]
Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
import java.util.ArrayList;
import java.util.List;

public class Easy_448 {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int i = 0;
		List<Integer> results = new ArrayList<>();
		while (i < nums.length) {
			int j = nums[i] - 1;
			if (nums[i] != nums[j]) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			} else {
				i++;
			}
		}
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != j + 1) {
				results.add(j + 1);
			}
		}
		return results;
	}

	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));//
		System.out.println(findDisappearedNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 }));
	}

}
