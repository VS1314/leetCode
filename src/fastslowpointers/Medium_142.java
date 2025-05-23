package fastslowpointers;
/*
 * 142. Linked List Cycle II
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.
Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:
Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
Constraints:
The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */

public class Medium_142 {

	public static ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		int cycleCount = 0;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			cycleCount++;
			if (slow == fast) {
				System.out.println(cycleCount);
				return findStart(head, cycleCount);
			}
		}
		return null;
	}

	private static ListNode findStart(ListNode head, int cycleCount) {
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		while (cycleCount > 0) {
			pointer2 = pointer2.next;
			cycleCount--;
		}
		while (pointer1 != pointer2) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return pointer1;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		System.out.println(detectCycle(head));
		head.next.next.next.next.next.next = head.next.next;
		System.out.println(detectCycle(head));
		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println(detectCycle(head));
		head.next.next.next.next.next.next = head;
		System.out.println(detectCycle(head));

	}

}
