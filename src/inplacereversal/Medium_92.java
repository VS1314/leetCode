package inplacereversal;

/*
 * 92. Reverse Linked List II
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]
Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
Follow up: Could you do it in one pass?
 */
public class Medium_92 {

	public static ListNode reverseBetweenI(ListNode head, int left, int right) {
		if (head == null || left == right) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		for (int i = 1; i < left; i++) {
			prev = prev.next;
		}
		ListNode curr = prev.next;
		for (int i = 0; i < right - left; i++) {
			ListNode temp = curr.next;
			curr.next = temp.next;
			temp.next = prev.next;
			prev.next = temp;
		}

		return dummy.next;
	}

	public static ListNode reverseBetweenII(ListNode head, int left, int right) {
		if (head == null || left == right) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode leftNode = dummy;
		ListNode currNode = head;
		for (int i = 1; i < left; i++) {
			leftNode = leftNode.next;
			currNode = currNode.next;
		}
		ListNode subListNode = currNode;
		ListNode prevNode = null;
		for (int i = 0; i <= right - left; i++) {
			ListNode nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		leftNode.next = prevNode;
		subListNode.next = currNode;
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		// reverseBetweenI(head, 2, 4);
		reverseBetweenII(head, 2, 4);
	}

}
