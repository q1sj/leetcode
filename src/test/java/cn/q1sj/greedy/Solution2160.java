package cn.q1sj.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 拆分数位后四位数字的最小和
 *
 * @author Q1sj
 * @date 2023.12.27 11:01
 */
public class Solution2160 {
	/**
	 * 示例 1：
	 * <p>
	 * 输入：num = 2932
	 * 输出：52
	 * 解释：可行的 [new1, new2] 数对为 [29, 23] ，[223, 9] 等等。
	 * 最小和为数对 [29, 23] 的和：29 + 23 = 52 。
	 * <p>
	 * 示例 2：
	 * <p>
	 * 输入：num = 4009
	 * 输出：13
	 * 解释：可行的 [new1, new2] 数对为 [0, 49] ，[490, 0] 等等。
	 * 最小和为数对 [4, 9] 的和：4 + 9 = 13 。
	 * <p>
	 * 提示：
	 * <p>
	 * 1000 <= num <= 9999
	 */
	@Test
	public void test() {
		Solution2160 solution = new Solution2160();
		Assert.assertEquals(52, solution.minimumSum(2932));
		Assert.assertEquals(13, solution.minimumSum(4009));
	}

	/**
	 * 给你一个四位 正 整数 num 。请你使用 num 中的 数位 ，将 num 拆成两个新的整数 new1 和 new2 。new1 和 new2 中可以有 前导 0 ，且 num 中 所有 数位都必须使用。
	 * <p>
	 * 比方说，给你 num = 2932 ，你拥有的数位包括：两个 2 ，一个 9 和一个 3 。一些可能的 [new1, new2] 数对为 [22, 93]，[23, 92]，[223, 9] 和 [2, 329] 。
	 * <p>
	 * 请你返回可以得到的 new1 和 new2 的 最小 和。
	 *
	 * @param num
	 * @return
	 */
	public int minimumSum(int num) {
		int i1 = num / 1000; // 2
		int i2 = num / 100 - i1 * 10; // 29-20 9
		int i3 = num / 10 - i2 * 10 - i1 * 100; // 293 - 9*10 -2 * 100
		int i4 = num - i3 * 10 - i2 * 100 - i1 * 1000;
		int[] nums = {i1, i2, i3, i4};
		Arrays.sort(nums);
		return nums[0] * 10 + nums[1] * 10 + nums[2] + nums[3];
	}
}
