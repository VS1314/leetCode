package leetcode.easy;

/*14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */
public class Easy_14 {

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		// Take the first string as the reference for comparison
		String prefix = strs[0];

		// Iterate through the rest of the strings
		for (int i = 1; i < strs.length; i++) {
			int j = 0;

			// Compare characters of the current string with the prefix
			while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
				j++;
			}

			// Update the prefix to the common part
			prefix = prefix.substring(0, j);

			// If the prefix becomes empty, there is no common prefix
			if (prefix.isEmpty()) {
				break;
			}
		}

		return prefix;
	}

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(Easy_14.longestCommonPrefix(strs));
	}

}
