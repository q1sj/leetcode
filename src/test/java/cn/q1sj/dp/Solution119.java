package cn.q1sj.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 119杨辉三角2
 *
 * @author Q1sj
 * @date 2023.12.26 15:18
 */
public class Solution119 {
	/**
	 * 示例 1:
	 * <p>
	 * 输入: rowIndex = 3
	 * 输出: [1,3,3,1]
	 * 示例 2:
	 * <p>
	 * 输入: rowIndex = 0
	 * 输出: [1]
	 * 示例 3:
	 * <p>
	 * 输入: rowIndex = 1
	 * 输出: [1,1]
	 */
	@Test
	public void test() {
		Solution119 solution = new Solution119();
		Assert.assertEquals(Arrays.asList(1, 3, 3, 1), solution.getRow(3));
		Assert.assertEquals(Collections.singletonList(1), solution.getRow(0));
		Assert.assertEquals(Arrays.asList(1, 1), solution.getRow(1));
		Assert.assertEquals(Arrays.asList(1, 8, 28, 56, 70, 56, 28, 8, 1), solution.getRow(8));

	}

	/**
	 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
	 * <p>
	 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
	 *
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		List<Integer> temp;
		for (int i = 0; i <= rowIndex; i++) {
			temp = new ArrayList<>(list);
			list.clear();
			for (int j = 0; j < i + 1; j++) {
				if (j == 0 || j == i) {
					list.add(1);
				} else {
					list.add(temp.get(j - 1) + temp.get(j));
				}
			}
		}
		return list;
	}
}
