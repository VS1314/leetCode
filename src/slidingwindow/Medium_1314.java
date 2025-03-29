package slidingwindow;
/*
 * 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.

 

Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
Example 2:

Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
 

Constraints:

1 <= arr.length <= 105
1 <= arr[i] <= 104
1 <= k <= arr.length
0 <= threshold <= 104
 */

public class Medium_1314 {

	public static int numOfSubarrays(int[] arr, int k, int threshold) {
		int numberofSub_arrays = 0;
		int start = 0;
		int sum = 0;

		for (int end = 0; end < arr.length; end++) {
			sum += arr[end];
			if ((end - start + 1) == k) {
				if (sum / k >= threshold) {
					numberofSub_arrays++;
				}
				sum -= arr[start];
				start++;
			}
		}
		return numberofSub_arrays;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 2, 5, 5, 5, 8 };
		int k = 3;
		int threshold = 4;
		int[] arr1 = { 11, 13, 17, 23, 29, 31, 7, 5, 2, 3 };
		int k1 = 3;
		int threshold1 = 5;
		System.out.println(Medium_1314.numOfSubarrays(arr1, k1, threshold1));

	}

}
