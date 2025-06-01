package inplacereversal;

/*
	25. Reverse Nodes in k-Group
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Constraints:
The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class Hard_25 {

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode temp = head;
		ListNode prev = null;
		while (temp != null) {
			ListNode kthNode = findKthNode(temp, k);
			if (kthNode == null) {
				if (prev != null) {
					prev.next = temp;
				}
				break;
			}
			ListNode next = kthNode.next;
			kthNode.next = null;
			reverseIteratively(temp);
			if (head == temp) {
				head = kthNode;
			} else {
				prev.next = kthNode;
			}
			prev = temp;
			temp = next;
		}
		return head;
	}

	private static ListNode findKthNode(ListNode temp, int k) {
		while (temp != null && k > 1) {
			temp = temp.next;
			k--;
		}
		return temp;
	}

	private static ListNode reverseIteratively(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode nextNode = head.next;
			head.next = prev;
			prev = head;
			head = nextNode;
		}
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		// head.next.next.next.next.next = new ListNode(6);
		reverseKGroup(head, 6);
	}

}
