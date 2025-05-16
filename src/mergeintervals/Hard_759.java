package mergeintervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
	int start;
	int end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}

}

public class Hard_759 {

	public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedules) {
		List<Interval> resut = new ArrayList<>();
		PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
		for (List<Interval> list : schedules) {
			pq.addAll(list);
		}
		Interval prev = pq.poll();
		while (!pq.isEmpty()) {
			Interval curr = pq.poll();
			if (prev.end < curr.start) {
				resut.add(new Interval(prev.end, curr.start));
				prev = curr;
			} else {
				prev.end = Math.max(prev.end, curr.end);
			}
		}
		return resut;
	}

	public static void main(String[] args) {
		List<List<Interval>> schedule = new ArrayList<>();

		// Employee 1: [1,2], [5,6]
		List<Interval> emp1 = new ArrayList<>();
		emp1.add(new Interval(1, 2));
		emp1.add(new Interval(5, 6));

		// Employee 2: [1,3]
		List<Interval> emp2 = new ArrayList<>();
		emp2.add(new Interval(1, 3));

		// Employee 3: [4,10]
		List<Interval> emp3 = new ArrayList<>();
		emp3.add(new Interval(4, 10));

		schedule.add(emp1);
		schedule.add(emp2);
		schedule.add(emp3);
		List<Interval> freeTime = findEmployeeFreeTime(schedule);
		for (Interval interval : freeTime) {
			System.out.println(interval.toString());
		}
	}

}
