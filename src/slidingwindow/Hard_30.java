package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 30. Substring with Concatenation of All Words

You are given a string s and an array of strings words. All the strings of words are of the same length.
A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation:
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Explanation:
There is no concatenated substring.
Example 3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]

Explanation:
The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].

Constraints:
1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
 */

public class Hard_30 {

	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		if (s == null || words == null || words.length == 0)
			return result;

		int wordLength = words[0].length();
		int wordCount = words.length;
		int totalLength = wordLength * wordCount;
		int sLength = s.length();

		if (sLength < totalLength)
			return result;

		// Build frequency map of words
		Map<String, Integer> wordFreq = new HashMap<>();
		for (String word : words) {
			wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
		}

		// Iterate over all possible start points
		for (int i = 0; i < wordLength; i++) {
			int left = i, right = i, matchedWords = 0;
			Map<String, Integer> windowMap = new HashMap<>();

			while (right + wordLength <= sLength) {
				String word = s.substring(right, right + wordLength);
				right += wordLength;

				if (wordFreq.containsKey(word)) {
					windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
					if (windowMap.get(word).equals(wordFreq.get(word))) {
						matchedWords++;
					}
				}

				// If window size exceeds the totalLength, shrink it
				if (right - left == totalLength) {
					if (matchedWords == wordFreq.size()) {
						result.add(left);
					}
					String leftWord = s.substring(left, left + wordLength);
					left += wordLength;

					if (wordFreq.containsKey(leftWord)) {
						if (windowMap.get(leftWord).equals(wordFreq.get(leftWord))) {
							matchedWords--;
						}
						windowMap.put(leftWord, windowMap.get(leftWord) - 1);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] words = { "foo", "bar" };
		String[] words1 = { "word", "good", "best", "word" };
		String[] words2 = { "bar", "foo", "the" };
		System.out.println(findSubstring("barfoothefoobarman", words));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", words1));
		System.out.println(findSubstring("barfoofoobarthefoobarman", words2));
	}

}
