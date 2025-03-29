package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 259. 3sum-smaller
 * 
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target 
 * where i, j, and k are three different indices. Write a function to return the count of such triplets.
 * 
 *  tripletWithSmallerSum ([-1, 0, 2, 3], 3)//2, There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
	tripletWithSmallerSum ([-1, 4, 2, 1, 3], 5)//4, There are four triplets whose sum is less than the target: [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
	tripletWithSmallerSum ([-2,0,1,3], 2)//2, Because there are two triplets which sums are less than 2: [-2,0,1], [-2,0,3]
	tripletWithSmallerSum ([], 0)//0
	tripletWithSmallerSum ([0], 0)//0
 */

public class Medium_259 {

	public static int tripletWithSmallerSum(int[] arr, int target) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			count += searchPairs(arr, target - arr[i], i + 1);
		}

		return count;
	}

	private static int searchPairs(int[] arr, int targetSum, int left) {
		int right = arr.length - 1;
		int count = 0;

		while (left < right) {
			if (arr[left] + arr[right] < targetSum) {
				// If sum is less than target, all pairs (left, left+1 ... right) are valid
				count += (right - left);
				left++; // Move left pointer to consider new pairs
			} else {
				right--; // Reduce sum by moving right pointer left
			}
		}

		return count;
	}

	// Write a function to return the list of all such triplets instead of the
	// count. How will the time complexity change in this case?
	public static List<List<Integer>> searchTriplets(int[] arr, int target) {
		Arrays.sort(arr); // Sort the array
		List<List<Integer>> triplets = new ArrayList<>();

		for (int i = 0; i < arr.length - 2; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				// Skip duplicate elements to avoid duplicate triplets
				continue;
			}
			searchPair(arr, target - arr[i], i, triplets);
		}
		return triplets;
	}

	private static void searchPair(int[] arr, int targetSum, int first, List<List<Integer>> triplets) {
		int left = first + 1, right = arr.length - 1;

		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum < targetSum) {
				// Since arr[right] is the largest in this range, all pairs (arr[left],
				// arr[left+1], ..., arr[right]) will be valid
				for (int i = right; i > left; i--) {
					triplets.add(Arrays.asList(arr[first], arr[left], arr[i]));
				}
				left++; // Move left pointer to find new pairs
			} else {
				right--; // Move right pointer to reduce the sum
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
		System.out.println(searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
		System.out.println(searchTriplets(new int[] { -2, 0, 1, 3 }, 2));
		System.out.println(tripletWithSmallerSum(new int[] {}, 0));
		System.out.println(tripletWithSmallerSum(new int[] { 0 }, 0));

	}

}
