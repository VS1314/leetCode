package fastslowpointers;

/*
 * 143. Reorder List
You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
Constraints:
The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
 */
public class Medium_143 {

	public static void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode second = reverse(slow.next);
		slow.next = null;
		ListNode first = head;
		while (second != null) {
			ListNode temp1 = first.next;
			ListNode temp2 = second.next;

			first.next = second;
			second.next = temp1;

			first = temp1;
			second = temp2;
		}
	}

	private static ListNode reverse(ListNode slow) {
		ListNode prev = null;
		while (slow != null) {
			ListNode nextNode = slow.next;
			slow.next = prev;
			prev = slow;
			slow = nextNode;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(12);
		reorderList(head);
	}

}
