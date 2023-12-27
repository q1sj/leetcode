package cn.q1sj.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * 爬楼梯
 *
 * @author Q1sj
 * @date 2023.12.27 9:32
 */
public class Solution70 {
	/**
	 * 示例 1：
	 * <p>
	 * 输入：n = 2
	 * 输出：2
	 * 解释：有两种方法可以爬到楼顶。
	 * 1. 1 阶 + 1 阶
	 * 2. 2 阶
	 * 示例 2：
	 * <p>
	 * 输入：n = 3
	 * 输出：3
	 * 解释：有三种方法可以爬到楼顶。
	 * 1. 1 阶 + 1 阶 + 1 阶
	 * 2. 1 阶 + 2 阶
	 * 3. 2 阶 + 1 阶
	 */
	@Test
	public void test() {
		Solution70 solution = new Solution70();
		Assert.assertEquals(2, solution.climbStairs(2));
		Assert.assertEquals(3, solution.climbStairs(3));
	}

	/**
	 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	 * <p>
	 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	 *
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int[] ints = new int[n + 1];
		ints[1] = 1;
		ints[2] = 2;
		for (int i = 3; i <= n; i++) {
			ints[i] = ints[i - 2] + ints[i - 1];
		}
		return ints[n];
	}
}
