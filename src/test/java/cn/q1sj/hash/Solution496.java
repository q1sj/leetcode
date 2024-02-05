package cn.q1sj.hash;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 下一个更大元素1
 *
 * @author Q1sj
 * @date 2024.2.5 11:13
 */
public class Solution496 {
	/**
	 * 示例 1：
	 * <p>
	 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
	 * 输出：[-1,3,-1]
	 * 解释：nums1 中每个值的下一个更大元素如下所述：
	 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
	 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
	 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
	 * 示例 2：
	 * <p>
	 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
	 * 输出：[3,-1]
	 * 解释：nums1 中每个值的下一个更大元素如下所述：
	 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
	 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
	 * 提示：
	 * <p>
	 * 1 <= nums1.length <= nums2.length <= 1000
	 * 0 <= nums1[i], nums2[i] <= 104
	 * nums1和nums2中所有整数 互不相同
	 * nums1 中的所有整数同样出现在 nums2 中
	 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
	 */
	@Test
	public void test() {
		Solution496 solution = new Solution496();
		Assert.assertArrayEquals(new int[]{-1, 3, -1}, solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
		Assert.assertArrayEquals(new int[]{3, -1}, solution.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}));
		//	测试用例:[1,3,5,2,4]
		//			[6,5,4,3,2,1,7]
		//	测试结果:[7,-1,-1,-1,-1]
		//	期望结果:[7,7,7,7,7]
		Assert.assertArrayEquals(new int[]{7, 7, 7, 7, 7}, solution.nextGreaterElement(new int[]{1, 3, 5, 2, 4}, new int[]{6, 5, 4, 3, 2, 1, 7}));

	}

	/**
	 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
	 * <p>
	 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
	 * <p>
	 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
	 * <p>
	 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] ans = new int[nums1.length];
		// nums2[i],i
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			map.put(nums2[i], i);
		}
		a:
		for (int i = 0; i < nums1.length; i++) {
			Integer nums2index = map.get(nums1[i]);
			while (nums2index + 1 < nums2.length) {
				if (nums2[nums2index + 1] > nums1[i]) {
					ans[i] = nums2[nums2index + 1];
					continue a;
				} else {
					nums2index++;
				}
			}
			ans[i] = -1;
		}
		return ans;
	}
}
