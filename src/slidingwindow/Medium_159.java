package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * 159. Longest Substring with at most 2 distinct characters
 * Given a string, find the length of the longest substring, which has no repeating characters.

lengthOfLongestSubstringTwoDistinct('eceba')//3
lengthOfLongestSubstringTwoDistinct('ccaabbb')//5
 */
public class Medium_159 {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int maxSubstring = 0;
		int start = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int end = 0; end < s.length(); end++) {
			if (map.containsKey(s.charAt(end))) {
				map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
			} else {
				map.put(s.charAt(end), 1);
			}
			while (map.size() > 2) {
				map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
				if (map.get(s.charAt(start)) == 0) {
					map.remove(s.charAt(start));
				}
				start++;
			}
			maxSubstring = Math.max(maxSubstring, end - start + 1);
		}
		return maxSubstring;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));// 3
		System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));// 5
	}

}
