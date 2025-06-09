package tree_BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 111. Minimum Depth of Binary Tree
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
Constraints:
The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
 */
public class Easy_111 {

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int level = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.remove();
				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
				if (curr.left == null && curr.right == null) {
					return level;
				}
			}
			level++;
		}
		return level;
	}

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(12);
//		root.left = new TreeNode(7);
//		root.right = new TreeNode(1);
//		root.left.left = new TreeNode(9);
//		root.left.right = new TreeNode(2);
//		root.right.left = new TreeNode(10);
//		root.right.right = new TreeNode(5);
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(minDepth(root));
	}

}
