package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 252. Meeting Rooms
 */
public class Easy_252 {

	public static boolean canAttendAllAppointments(int[][] appointmentTimes) {
		Arrays.sort(appointmentTimes, (a, b) -> Integer.compare(a[0], b[0]));
		for (int i = 1; i < appointmentTimes.length; i++) {
			if (appointmentTimes[i][0] < appointmentTimes[i - 1][1]) {
				return false;
			}
		}
		return true;
	}

	public static List<List<int[]>> whatAreTheConflicts(int[][] appointments) {
		List<List<int[]>> conflicts = new ArrayList<>();

		// Sort by start time
		Arrays.sort(appointments, Comparator.comparingInt(a -> a[0]));

		for (int i = 0; i < appointments.length - 1; i++) {
			for (int j = i + 1; j < appointments.length; j++) {
				// Break early if no overlap (thanks to sorting)
				if (appointments[j][0] >= appointments[i][1])
					break;

				if (appointments[i][1] > appointments[j][0]) {
					conflicts.add(Arrays.asList(appointments[i], appointments[j]));
				}
			}
		}

		return conflicts;
	}

	public static void main(String[] args) {
		System.out.println(canAttendAllAppointments(new int[][] { { 1, 4 }, { 2, 5 }, { 7, 9 } }));
		System.out.println(canAttendAllAppointments(new int[][] { { 6, 7 }, { 2, 4 }, { 8, 12 } }));
		System.out.println(canAttendAllAppointments(new int[][] { { 4, 5 }, { 2, 3 }, { 3, 6 } }));

		List<List<int[]>> list1 = whatAreTheConflicts(new int[][] { { 1, 4 }, { 2, 5 }, { 7, 9 } });
		System.out.println("Printing list1:-");
		for (List<int[]> is : list1) {
			for (int[] list : is) {
				System.out.println(Arrays.toString(list));
			}
		}
		List<List<int[]>> list2 = whatAreTheConflicts(new int[][] { { 4, 5 }, { 2, 3 }, { 3, 6 } });
		System.out.println("Printing list2:-");
		for (List<int[]> is : list2) {
			for (int[] list : is) {
				System.out.println(Arrays.toString(list));
			}
		}
		List<List<int[]>> list3 = whatAreTheConflicts(new int[][] { { 6, 7 }, { 2, 4 }, { 8, 12 } });
		System.out.println("Printing list3:-");
		for (List<int[]> is : list3) {
			for (int[] list : is) {
				System.out.println(Arrays.toString(list));
			}
		}
		List<List<int[]>> list4 = whatAreTheConflicts(new int[][] { { 4, 5 }, { 2, 3 }, { 3, 6 }, { 5, 7 }, { 7, 8 } });
		System.out.println("Printing list4:-");
		for (List<int[]> is : list4) {
			for (int[] list : is) {
				System.out.println(Arrays.toString(list));
			}
		}
	}

}
