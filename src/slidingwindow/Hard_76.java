package slidingwindow;
/*
 * 76. Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window 
substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 
Constraints:
m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 
	Follow up: Could you find an algorithm that runs in O(m + n) time?
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class Hard_76 {

	public static String minWindow(String s, String t) {
		int windowStart = 0;
		int isMatch = 0;
		int substrStart = 0;
		int minLength = s.length() + 1;
		Map<Character, Integer> charFrequency = new HashMap<>();
		for (char ch : t.toCharArray()) {
			charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
		}
		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char endChar = s.charAt(windowEnd);

			if (charFrequency.containsKey(endChar)) {
				// Decrease the frequency of the matched character
				charFrequency.put(endChar, charFrequency.get(endChar) - 1);
				if (charFrequency.get(endChar) == 0) {
					isMatch++;
				}
			}
			while (isMatch == charFrequency.size()) {
				if (windowEnd - windowStart + 1 < minLength) {
					minLength = windowEnd - windowStart + 1;
					substrStart = windowStart;
				}
				char startChar = s.charAt(windowStart);
				windowStart++;
				if (charFrequency.containsKey(startChar)) {
					if (charFrequency.get(startChar) == 0) {
						isMatch--;
					}
					charFrequency.put(startChar, charFrequency.get(startChar) + 1);
				}
			}
		}
		if (minLength > s.length()) {
			return "";
		}
		return s.substring(substrStart, substrStart + minLength);
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
		System.out.println(minWindow("a", "aa"));

	}

}
