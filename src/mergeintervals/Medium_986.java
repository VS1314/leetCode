package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
57. Insert Interval
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.
Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
Constraints:
0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
 */
public class Medium_986 {

	public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		List<int[]> result = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < firstList.length && j < secondList.length) {
			boolean firstOverlapsSecond = firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1];
			boolean secondOverlapsFirst = secondList[j][0] >= firstList[i][0] && secondList[j][0] <= firstList[i][1];
			if (firstOverlapsSecond || secondOverlapsFirst) {
				result.add(new int[] { 
						Math.max(firstList[i][0], secondList[j][0]),
						Math.min(firstList[i][1], secondList[j][1]) });
			}
			if (firstList[i][1] < secondList[j][1]) {
				i++;
			} else {
				j++;
			}
		}
		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		int[][] is = intervalIntersection(new int[][] { { 1, 3 }, { 5, 6 }, { 7, 9 } },
				new int[][] { { 2, 3 }, { 5, 7 } });
//		int[][] is = intervalIntersection(new int[][] { { 1, 3 }, { 5, 7 }, { 9, 12 } }, new int[][] { { 5, 10 } });
		for (int[] is2 : is) {
			System.out.println(Arrays.toString(is2));
		}
	}

}
