package twopointers;

/*
 * 844. Backspace String Compare
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.
Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
Constraints:
1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class Easy_844 {

	public static boolean backspaceCompare(String s, String t) {
		int pointerOne = s.length() - 1;
		int pointerTwo = t.length() - 1;
		while (pointerOne >= 0 || pointerTwo >= 0) {
			int i = getNextChar(s, pointerOne);
			int j = getNextChar(t, pointerTwo);
			if (i < 0 && j < 0) {
				return true;
			}
			if (i < 0 || j < 0) {
				return false;
			}
			if (s.charAt(i) != t.charAt(j)) {
				return false;
			}
			pointerOne = i - 1;
			pointerTwo = j - 1;
		}
		return true;
	}

	private static int getNextChar(String str, int index) {
		int backSpaceCount = 0;
		while (index >= 0) {
			if (str.charAt(index) == '#') {
				backSpaceCount++;
			} else if (backSpaceCount > 0) {
				backSpaceCount--;
			} else {
				break;
			}
			index--;
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c"));
		System.out.println(backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceCompare("a#c", "b"));
		System.out.println(backspaceCompare("xy#z", "xzz#"));
		System.out.println(backspaceCompare("xy#z", "xyz#"));
		System.out.println(backspaceCompare("xp#", "xyz##"));

	}

}
