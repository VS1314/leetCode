package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.

("araaci", 2)//4, The longest substring with no more than '2' distinct characters is "araa".
("araaci", 1)//2, The longest substring with no more than '1' distinct characters is "aa".
("cbbebi", 3)//5, The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class Medium_340 {

	public static int longestSubstringWithKdistinct(String str, int k) {
		int start = 0;
		int longestSubstringWithKdistinct = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int end = 0; end < str.length(); end++) {
			map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);
			while (map.size() > k) {
				map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
				if (map.get(str.charAt(start)) == 0) {
					map.remove(str.charAt(start));
				}
				start++;
			}
			longestSubstringWithKdistinct = Math.max(longestSubstringWithKdistinct, end - start + 1);
		}
		return longestSubstringWithKdistinct;
	}

	public static void main(String[] args) {
		String s = "araaci";
		String s1 = "araaci";
		String s2 = "cbbebi";
		int k = 2;
		int k1 = 1;
		int k2 = 3;
		System.out.println(longestSubstringWithKdistinct(s, k));
	}

}
