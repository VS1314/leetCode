package cyclicsort;

public class Easy_268 {

	public static int missingNumber(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			int j = nums[i];
			if (nums[i] < nums.length && nums[i] != nums[j]) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			} else {
				i++;
			}
		}
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != j) {
				return j;
			}
		}
		return nums.length;
	}

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] { 4, 0, 3, 2 }));
		System.out.println(missingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
	}

}
