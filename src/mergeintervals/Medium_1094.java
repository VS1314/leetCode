package mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 1094. Car Pooling
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
Example 1:
Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:
Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Constraints:
1 <= trips.length <= 1000
trips[i].length == 3
1 <= numPassengersi <= 100
0 <= fromi < toi <= 1000
1 <= capacity <= 105
 */
public class Medium_1094 {

	public static boolean carPooling(int[][] trips, int capacity) {

		Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
		PriorityQueue<int[]> endTimePQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		int passengers = 0;
		for (int i = 0; i < trips.length; i++) {
			while (!endTimePQ.isEmpty() && trips[i][1] >= endTimePQ.peek()[2]) {
				int gotDown = endTimePQ.poll()[0];
				passengers -= gotDown;
			}
			passengers += trips[i][0];
			endTimePQ.add(trips[i]);
			if (passengers > capacity) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(carPooling(new int[][] { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 }, { 2, 10, 12 } }, 11));
	}

}
