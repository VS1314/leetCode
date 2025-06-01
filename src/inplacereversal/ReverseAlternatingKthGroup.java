package inplacereversal;

public class ReverseAlternatingKthGroup {

	public static ListNode reverseAlternatingKthElement(ListNode head, int k) {
		boolean reverse = true;
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
			if (reverse) {
				reverseIteratively(temp);
				if (head == temp) {
					head = kthNode;
				} else {
					prev.next = kthNode;
				}
				prev = temp;

			} else {
				if (prev != null) {
					prev.next = temp;
				}
				prev = kthNode;
			}
			temp = next;
			reverse = !reverse;
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
		//head.next.next.next.next.next = new ListNode(6);
		reverseAlternatingKthElement(head, 3);
	}

}
