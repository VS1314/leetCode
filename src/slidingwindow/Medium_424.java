package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * 424. Longest Repeating Character Replacement
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
Constraints:
1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */

public class Medium_424 {

	public static int characterReplacement(String s, int k) {
		int Start = 0;
		int maxLength = 0;
		int maxRepeatLetterCount = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int end = 0; end < s.length(); end++) {
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
			maxRepeatLetterCount = Math.max(map.get(s.charAt(end)), maxRepeatLetterCount);
			if ((end - Start + 1 - maxRepeatLetterCount) > k) {
				map.put(s.charAt(Start), map.get(s.charAt(Start)) - 1);
				Start++;
			}
			maxLength = Math.max(maxLength, end - Start + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String s = "ABAB";
		int k = 2;
		String s1 = "AABABBA";
		int k1 = 1;
		System.out.println(characterReplacement(s1, k1));
	}
}