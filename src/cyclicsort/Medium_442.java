package cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class Medium_442 {

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> results = new ArrayList<>();
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
				results.add(nums[j]);
			}
		}
		return results;
	}

	public static void main(String[] args) {

		System.out.println(findDuplicates(new int[] { 3, 4, 4, 5, 5 }));//
		System.out.println(findDuplicates(new int[] { 5, 4, 7, 2, 3, 5, 3 }));
	}

}
