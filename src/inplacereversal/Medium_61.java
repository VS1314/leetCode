package inplacereversal;

/*
 * 61. Rotate List
Given the head of a linked list, rotate the list to the right by k places.
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */
public class Medium_61 {

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		int length = 1;
		ListNode tail = head;
		ListNode temp = head;
		while (tail.next != null) {
			tail = tail.next;
			length++;
		}
		if (k % length == 0) {
			return head;
		}
		k = k % length;
		tail.next = head;
		ListNode kthNode = findKthNode(temp, length - k);
		head = kthNode.next;
		kthNode.next = null;
		return head;
	}

	private static ListNode findKthNode(ListNode temp, int k) {
		while (temp != null && k > 1) {
			temp = temp.next;
			k--;
		}
		return temp;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		rotateRight(head, 5);
	}

}
