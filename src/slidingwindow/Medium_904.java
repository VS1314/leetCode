package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 904. Fruit Into Baskets
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.
Example 1:
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:
Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:
Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
Constraints:
1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length
 */
public class Medium_904 {

	public static int totalFruit(int[] fruits) {
		int maxFruit = 0;
		int start = 0;
		int n = fruits.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int end = 0; end < n; end++) {
			int number = fruits[end];
			if (!map.containsKey(number)) {
				map.put(number, map.getOrDefault(number, 0) + 1);
			} else {
				map.put(number, map.get(number) + 1);
			}
			while (map.size() > 2) {
				number = fruits[start];
				map.put(number, map.get(number) - 1);
				if (map.get(number) == 0) {
					map.remove(number);
				}
				start++;
			}
			maxFruit = Math.max(maxFruit, end - start + 1);
		}
		return maxFruit;
	}

	public static void main(String[] args) {
		int[] fruits = { 1, 2, 1 };
		int[] fruits1 = { 0, 1, 2, 2 };
		int[] fruits2 = { 1, 2, 3, 2, 2 };
		int[] fruits3 = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
		System.out.println(totalFruit(fruits3));
	}

}
