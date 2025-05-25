package cyclicsort;

import java.util.Arrays;

public class CorruptPair {

	public static int[] findCorruptNumbers(int[] nums) {
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
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return new int[] { nums[i], i + 1 };
			}
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findCorruptNumbers(new int[] { 3, 1, 2, 5, 2 })));//
		System.out.println(Arrays.toString(findCorruptNumbers(new int[] { 3, 1, 2, 3, 6, 4 })));
	}

}
