package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 438. Find All Anagrams in a String
Given two strings s and p, return an array of all the start indices of p's 
anagrams in s. You may return the answer in any order.
Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
Constraints:
1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 */

public class Medium_438 {

	public static List<Integer> findAnagrams(String s, String p) {

		int windowStart = 0;
		int isMatch = 0;
		Map<Character, Integer> charFrequency = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		// Build frequency map of the pattern
		for (char ch : s.toCharArray()) {
			charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
		}

		// Sliding window
		for (int windowEnd = 0; windowEnd < p.length(); windowEnd++) {
			char endChar = p.charAt(windowEnd);

			if (charFrequency.containsKey(endChar)) {
				// Decrease the frequency of the matched character
				charFrequency.put(endChar, charFrequency.get(endChar) - 1);
				if (charFrequency.get(endChar) == 0) {
					isMatch++;
				}
			}

			// Check if all characters match
			if (isMatch == charFrequency.size()) {
				result.add(windowStart);
			}

			// Shrink the window if it exceeds the size of the pattern
			if (windowEnd >= s.length() - 1) {
				char startChar = p.charAt(windowStart);
				windowStart++;
				if (charFrequency.containsKey(startChar)) {
					if (charFrequency.get(startChar) == 0) {
						isMatch--;
					}
					charFrequency.put(startChar, charFrequency.get(startChar) + 1);
				}
			}
		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(findAnagrams("pq", "ppqp"));
		System.out.println(findAnagrams("abc", "abbcabc"));
		System.out.println(findAnagrams("abc", "cbaebabacd"));
	}

}
