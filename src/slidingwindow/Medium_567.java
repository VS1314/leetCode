package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * 567. Permutation in String
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
Constraints:
1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
 */
public class Medium_567 {

	public static boolean checkInclusion(String s1, String s2) {
		int windowStart = 0;
		int isMatch = 0;
		Map<Character, Integer> charFrequency = new HashMap<>();

		// Build frequency map of the pattern
		for (char ch : s1.toCharArray()) {
			charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
		}

		// Sliding window
		for (int windowEnd = 0; windowEnd < s2.length(); windowEnd++) {
			char endChar = s2.charAt(windowEnd);

			if (charFrequency.containsKey(endChar)) {
				// Decrease the frequency of the matched character
				charFrequency.put(endChar, charFrequency.get(endChar) - 1);
				if (charFrequency.get(endChar) == 0) {
					isMatch++;
				}
			}

			// Check if all characters match
			if (isMatch == charFrequency.size()) {
				return true;
			}

			// Shrink the window if it exceeds the size of the pattern
			if (windowEnd >= s1.length() - 1) {
				char startChar = s2.charAt(windowStart);
				windowStart++;
				if (charFrequency.containsKey(startChar)) {
					if (charFrequency.get(startChar) == 0) {
						isMatch--;
					}
					charFrequency.put(startChar, charFrequency.get(startChar) + 1);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));// true
		System.out.println(checkInclusion("ab", "eidboaoo"));// false
		System.out.println(checkInclusion("abc", "oidbcaf"));// true
		System.out.println(checkInclusion("dc", "odicf"));// false
		System.out.println(checkInclusion("bcdxabcdy", "bcdxabcdy"));// true
		System.out.println(checkInclusion("abc", "aaacb"));// true
	}
}
