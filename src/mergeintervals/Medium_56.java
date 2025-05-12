package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */
public class Medium_56 {

	public static int[][] merge(int[][] intervals) {
		if (intervals.length < 2) {
			return intervals;
		}
		// Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));//other way to sort
		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] j : intervals) {
			if (j[0] <= newInterval[1]) {
				newInterval[1] = Math.max(j[1], newInterval[1]);
			} else {
				newInterval = j;
				result.add(newInterval);
			}
		}
		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		int[][] is = merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } });
		for (int[] is2 : is) {
			System.out.println(Arrays.toString(is2));
		}
	}

}
