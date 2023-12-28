package cn.q1sj.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 装满被子需要的最短总时长
 *
 * @author Q1sj
 * @date 2023.12.28 15:52
 */
public class Solution2335 {
	/**
	 * 示例 1：
	 * <p>
	 * 输入：amount = [1,4,2]
	 * 输出：4
	 * 解释：下面给出一种方案：
	 * 第 1 秒：装满一杯冷水和一杯温水。
	 * 第 2 秒：装满一杯温水和一杯热水。
	 * 第 3 秒：装满一杯温水和一杯热水。
	 * 第 4 秒：装满一杯温水。
	 * 可以证明最少需要 4 秒才能装满所有杯子。
	 * <p>
	 * 示例 2：
	 * <p>
	 * 输入：amount = [5,4,4]
	 * 输出：7
	 * 解释：下面给出一种方案：
	 * 第 1 秒：装满一杯冷水和一杯热水。
	 * 第 2 秒：装满一杯冷水和一杯温水。
	 * 第 3 秒：装满一杯冷水和一杯温水。
	 * 第 4 秒：装满一杯温水和一杯热水。
	 * 第 5 秒：装满一杯冷水和一杯热水。
	 * 第 6 秒：装满一杯冷水和一杯温水。
	 * 第 7 秒：装满一杯热水。
	 * <p>
	 * 示例 3：
	 * <p>
	 * 输入：amount = [5,0,0]
	 * 输出：5
	 * 解释：每秒装满一杯冷水。
	 * <p>
	 * 提示：
	 * <p>
	 * amount.length == 3
	 * 0 <= amount[i] <= 100
	 */
	@Test
	public void test() {
		Solution2335 solution = new Solution2335();
		// 421 201 100 000
		Assert.assertEquals(4, solution.fillCups(new int[]{1, 4, 2}));
		//
		Assert.assertEquals(7, solution.fillCups(new int[]{5, 4, 4}));
		Assert.assertEquals(5, solution.fillCups(new int[]{5, 0, 0}));
	}

	/**
	 * 现有一台饮水机，可以制备冷水、温水和热水。每秒钟，可以装满 2 杯 不同 类型的水或者 1 杯任意类型的水。
	 * <p>
	 * 给你一个下标从 0 开始、长度为 3 的整数数组 amount ，其中 amount[0]、amount[1] 和 amount[2] 分别表示需要装满冷水、温水和热水的杯子数量。返回装满所有杯子所需的 最少 秒数。
	 *
	 * @param amount
	 * @return
	 */
	public int fillCups(int[] amount) {
		int step = 0;
		while (zeroCount(amount) < 2) {
			step++;
			Arrays.sort(amount);
			amount[2] -= 1;
			amount[1] -= 1;
		}
		if (zeroCount(amount) != 3) {
			Arrays.sort(amount);
			step += amount[2];
		}
		return step;
	}

	private int zeroCount(int[] amount) {
		int count = 0;
		for (int i : amount) {
			if (i == 0) {
				count++;
			}
		}
		return count;
	}
}
