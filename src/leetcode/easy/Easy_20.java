package leetcode.easy;

import java.util.Stack;

/*20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
public class Easy_20 {

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if (x == '(' || x == '[' || x == '{') {
				stack.push(x);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char y;
			switch (x) {
			case '}':
				y = stack.pop();
				if (y == '(' || y == '[')
					return false;
				break;
			case ']':
				y = stack.pop();
				if (y == '(' || y == '{')
					return false;
				break;
			case ')':
				y = stack.pop();
				if (y == '{' || y == '[')
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(Easy_20.isValid(s));
	}

}
