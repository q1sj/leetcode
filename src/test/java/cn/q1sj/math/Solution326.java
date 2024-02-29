package cn.q1sj.math;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 3的幂
 *
 * @author Q1sj
 * @date 2024.2.29 16:24
 */
public class Solution326 {
	@Test
	public void test() {
		Assert.assertFalse(isPowerOfThree(0));
		Assert.assertTrue(isPowerOfThree(1));
		Assert.assertTrue(isPowerOfThree(3));
		Assert.assertTrue(isPowerOfThree(9));
		Assert.assertFalse(isPowerOfThree(12));
		Assert.assertTrue(isPowerOfThree(27));
	}

	static Set<Integer> set = new HashSet<>();

	static {
		int n = 1;
		while (n > 0) {
			set.add(n);
			n = n * 3;
		}
	}

	public boolean isPowerOfThree(int n) {
		//	执行耗时:8 ms,击败了69.34% 的Java用户
		//	内存消耗:43.2 MB,击败了5.66% 的Java用户
		return set.contains(n);
	}

	public boolean isPowerOfThree2(int n) {
		//	执行耗时:7 ms,击败了99.93% 的Java用户
		//	内存消耗:43 MB,击败了34.30% 的Java用户
		while (n > 1 && n % 3 == 0) {
			n = n / 3;
		}
		return n == 1;
	}
}
