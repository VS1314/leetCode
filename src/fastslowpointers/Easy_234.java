package fastslowpointers;

/*
 * 234. Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false
Constraints:
The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
Follow up: Could you do it in O(n) time and O(1) space?
 */
public class Easy_234 {

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode reversedHalfListNode = reverse(slow);
		ListNode firstHalfListNode = head;
		while (reversedHalfListNode != null) {
			if (firstHalfListNode.val != reversedHalfListNode.val) {
				return false;
			}
			firstHalfListNode = firstHalfListNode.next;
			reversedHalfListNode = reversedHalfListNode.next;
		}
		return true;
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
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		System.out.println(isPalindrome(head));
	}

}
