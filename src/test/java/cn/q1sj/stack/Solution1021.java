package cn.q1sj.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 删除最外层的括号
 *
 * @author Q1sj
 * @date 2024.2.5 15:20
 */
public class Solution1021 {
	/**
	 * 示例 1：
	 * <p>
	 * 输入：s = "(()())(())"
	 * 输出："()()()"
	 * 解释：
	 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
	 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
	 * <p>
	 * 示例 2：
	 * <p>
	 * 输入：s = "(()())(())(()(()))"
	 * 输出："()()()()(())"
	 * 解释：
	 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
	 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
	 * <p>
	 * 示例 3：
	 * <p>
	 * 输入：s = "()()"
	 * 输出：""
	 * 解释：
	 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
	 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
	 */
	@Test
	public void test() {
		Solution1021 solution = new Solution1021();
		Assert.assertEquals("()()()", solution.removeOuterParentheses("(()())(())"));
		Assert.assertEquals("()()()()(())", solution.removeOuterParentheses("(()())(())(()(()))"));
		Assert.assertEquals("", solution.removeOuterParentheses("()()"));
	}

	/**
	 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
	 * <p>
	 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
	 * <p>
	 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
	 * <p>
	 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
	 * <p>
	 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
	 *
	 * @param s
	 * @return
	 */
	public String removeOuterParentheses(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				if (!stack.isEmpty()) {
					sb.append('(');
				}
				stack.push('(');
			}
			if (chars[i] == ')') {
				stack.pop();
				// 找到一组有效括号
				if (!stack.isEmpty()) {
					sb.append(')');
				}
			}
		}
		return sb.toString();
	}
}
