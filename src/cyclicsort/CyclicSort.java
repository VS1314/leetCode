package cyclicsort;

public class CyclicSort {

	public static int[] cyclicSort(int[] nums) {
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
		return nums;
	}

	public static void main(String[] args) {

		int[] sort = cyclicSort(new int[] { 2, 6, 4, 3, 1, 5 });
		for (int i : sort) {
			System.out.print(i + " ");
		}
	}

}
