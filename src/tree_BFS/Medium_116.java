package tree_BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 116. Populating Next Right Pointers in Each Node
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:
Input: root = []
Output: []
Constraints:
The number of nodes in the tree is in the range [0, 212 - 1].
-1000 <= Node.val <= 1000
Follow-up:
You may only use constant extra space.
The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int val) {
		this.val = val;
	}

	public Node(int val, Node left, Node right, Node next) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = next;
	}
}

public class Medium_116 {

	public static Node connect(Node root) {
		if (root == null)
			return null;
		Node levelStart = root;
		while (levelStart.left != null) {
			Node curr = levelStart;
			while (curr != null) {
				curr.left.next = curr.right;
				if (curr.next != null) {
					curr.right.next = curr.next.left;
				}
				curr = curr.next;
			}
			levelStart = levelStart.left;
		}
		return root;
	}

	public static Node connect1(Node root) {
		if (root == null)
			return null;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (q.size() > 0) {
			int size = q.size();
			Node prev = null;
			while (size-- > 0) {
				Node node = q.remove();
				node.next = prev;
				prev = node;
				if (node.right != null) {
					q.add(node.right);
				}
				if (node.left != null) {
					q.add(node.left);
				}
			}
		}
		return root;
	}

	public static Node connect2(Node root) {
		if (root == null || root.left == null)
			return root;
		root.left.next = root.right;
		if (root.next != null) {
			root.right.next = root.next.left;
		}
		connect2(root.left);
		connect2(root.right);
		return root;
	}

	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(7);
		root.right = new Node(1);
		root.left.left = new Node(9);
		root.left.right = new Node(2);
		root.right.left = new Node(10);
		root.right.right = new Node(5);
		connect2(root);
	}

}
