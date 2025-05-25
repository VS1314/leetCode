package cyclicsort;

/*
 * 287. Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.
Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
Example 3:
Input: nums = [3,3,3,3,3]
Output: 3
Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */
public class Medium_287 {

	public static int findDuplicate(int[] nums) {
		int i = 0;
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
				return nums[j];
			}
		}
		return -1;
	}

	public static int findDuplicateI(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] != i + 1) {
				int j = nums[i] - 1;
				if (nums[i] != nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				} else {
					return nums[i];
				}
			} else {
				i++;
			}
		}
		return -1;
	}

	public static int findDuplicateII(int[] nums) {

		// Phase 1: Detect cycle (meeting point)
		int slow = nums[0];
		int fast = nums[0];

		do {
			slow = nums[slow]; // move one step
			fast = nums[nums[fast]]; // move two steps
		} while (slow != fast);

		// Phase 2: Find entrance to the cycle
		slow = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return slow; // or fast, both are at the duplicate
	}

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));//
		System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));

		System.out.println(findDuplicateI(new int[] { 2, 1, 3, 3, 5, 4 }));//
		System.out.println(findDuplicateI(new int[] { 3, 3, 3, 3, 3 }));

		System.out.println(findDuplicateII(new int[] { 1, 3, 4, 2, 2 }));//
		System.out.println(findDuplicateII(new int[] { 3, 1, 3, 4, 2 }));

	}

}
