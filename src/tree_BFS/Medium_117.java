package tree_BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 117. Populating Next Right Pointers in Each Node II
Given a binary tree
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Example 1:
Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:
Input: root = []
Output: []
Constraints:
The number of nodes in the tree is in the range [0, 6000].
-100 <= Node.val <= 100
Follow-up:
You may only use constant extra space.
The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.
 */
public class Medium_117 {
	public static Node connect(Node root) {
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

	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(7);
		root.right = new Node(1);
		root.left.left = new Node(9);
		root.left.right = new Node(2);
		root.right.left = new Node(10);
		root.right.right = new Node(5);
		connect(root);
	}

}
