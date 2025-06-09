package tree_BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 1161. Maximum Level Sum of a Binary Tree
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
Example 1:
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:
Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
Constraints:
The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
 */
public class Medium_1161 {

	public static int maxLevelSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int maxLevel = 1;
		int level = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			int sum = 0;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.remove();
				sum += curr.val;
				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}
			}
			if (sum > max) {
				max = sum;
				maxLevel = level;
			}
			level++;
		}
		return maxLevel;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		System.out.println(maxLevelSum(root));

	}

}
