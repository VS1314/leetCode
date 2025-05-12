package mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 253. Meeting Rooms II
 */
public class Medium_253 {

	public static int minMeetingRooms(int[][] meetings) {

		if (meetings == null || meetings.length == 0)
			return 0;

		// Sort by start time
		Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

		// Min-heap to track earliest ending meeting
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		// Add the end time of the first meeting
		heap.add(meetings[0][1]);

		for (int i = 1; i < meetings.length; i++) {
			// If the current meeting starts after or when the earliest ends, reuse the room
			if (meetings[i][0] >= heap.peek()) {
				heap.poll(); // Remove the earliest ending meeting
			}
			heap.add(meetings[i][1]); // Add the current meeting's end time
		}

		return heap.size(); // Number of rooms = size of the heap}
	}

	public static void main(String[] args) {
		System.out.println(minMeetingRooms(new int[][] {}));
		System.out.println(minMeetingRooms(new int[][] { { 1, 4 } }));
		System.out.println(minMeetingRooms(new int[][] { { 1, 4 }, { 2, 5 }, { 7, 9 } }));
		System.out.println(minMeetingRooms(new int[][] { { 6, 7 }, { 2, 4 }, { 8, 12 } }));
		System.out.println(minMeetingRooms(new int[][] { { 1, 4 }, { 2, 3 }, { 3, 6 } }));
		System.out.println(minMeetingRooms(new int[][] { { 4, 5 }, { 2, 3 }, { 2, 4 }, { 3, 5 } }));
	}
}
