package cn.q1sj.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * 比较含退格的字符串
 *
 * @author Q1sj
 * @date 2024.2.5 15:05
 */
public class Solution844 {
	/**
	 * 示例 1：
	 * <p>
	 * 输入：s = "ab#c", t = "ad#c"
	 * 输出：true
	 * 解释：s 和 t 都会变成 "ac"。
	 * 示例 2：
	 * <p>
	 * 输入：s = "ab##", t = "c#d#"
	 * 输出：true
	 * 解释：s 和 t 都会变成 ""。
	 * 示例 3：
	 * <p>
	 * 输入：s = "a#c", t = "b"
	 * 输出：false
	 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
	 */
	@Test
	public void test() {
		Solution844 solution = new Solution844();
		Assert.assertTrue(solution.backspaceCompare("ab#c", "ad#c"));
		Assert.assertTrue(solution.backspaceCompare("ab##", "c#d#"));
		Assert.assertFalse(solution.backspaceCompare("a#c", "b"));
	}

	/**
	 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
	 * <p>
	 * 注意：如果对空文本输入退格字符，文本继续为空。
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean backspaceCompare(String s, String t) {
		return stringAfterBackspace(s).equals(stringAfterBackspace(t));
	}

	/**
	 * 生成退格后字符串
	 *
	 * @param s
	 * @return
	 */

	private static String stringAfterBackspace(String s) {
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '#') {
				if (sb.length() != 0) {
					sb.deleteCharAt(sb.length() - 1);
				}
				continue;
			}
			sb.append(chars[i]);
		}
		return sb.toString();
	}
}
