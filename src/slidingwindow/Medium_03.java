package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

/*
 * 3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest 
substring
 without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

public class Medium_03 {

	public static int lengthOfLongestSubstring(String s) {
		int lengthOfLongestSubstring = 0;
		int start = 0;
		HashSet<Character> set = new HashSet<>();
		s.trim();
		for (int end = 0; end < s.length(); end++) {
			char currentChar = s.charAt(end);
			if (!set.contains(currentChar)) {
				set.add(currentChar);
				lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, end - start + 1);
			} else {
				while (set.contains(currentChar)) {
					set.remove(s.charAt(start));
					start++;
				}
				set.add(currentChar);
			}
		}
		return lengthOfLongestSubstring;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		String s1 = "bbbbb";
		String s2 = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));

	}

}
