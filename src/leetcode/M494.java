package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M494 {
	/**
	 * �õݹ���DFS��˼·�򵥣�����򵥣������кܶ��ظ��ļ���
	 */
	private int sum = 0;

	public int findTargetSumWays(int[] nums, int S) {
		helper(nums, S, 0, 0);
		return sum;
	}

	public void helper(int[] nums, int S, int index, int cur) {
		if (index == nums.length && cur == S)
			sum++;
		if (index == nums.length)
			return;
		helper(nums, S, index + 1, cur + nums[index]);
		helper(nums, S, index + 1, cur - nums[index]);
	}

	/**
	 * ��̬�滮����¼�ߵ�ÿһ�����ܵ�ֵ ��ģ���ʱ�ˣ�����
	 * 
	 * @param nums
	 * @param S
	 * @return
	 */
	public int findTargetSumWays2(int[] nums, int S) {
		int res = 0;
		int len = nums.length;
		if (len == 0)
			return 0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(nums[0]);
		list.add(-nums[0]);
		for (int i = 1; i < len; i++) {
			List<Integer> cur = new ArrayList<Integer>();
			for (Integer n : list) {
				cur.add(n + nums[i]);
				cur.add(n - nums[i]);
			}
			list = cur;
		}
		for (Integer n : list)
			if (n == S)
				res++;
		return res;
	}

	/**
	 * �����˵�Ǳ������⣬�ö�̬�滮�����չٷ����д��һ�� �������ţ��
	 * 
	 * @param nums
	 * @param S
	 * @return
	 */
	public int findTargetSumWays3(int[] nums, int S) {
		int len = nums.length;
		int[][] bag = new int[len][2001];
		bag[0][1000 + nums[0]] = 1;
		bag[0][1000 - nums[0]] += 1;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < 2001; j++) {
				if (bag[i - 1][j] > 0) {
					bag[i][j + nums[i]] += bag[i - 1][j];
					bag[i][j - nums[i]] += bag[i - 1][j];
				}
			}
		}
		return S > 1000 ? 0 : bag[len - 1][S + 1000];
	}

	/**
	 * ��̬�滮�Ż��ռ�
	 * ����ţ��
	 * @param nums
	 * @param S
	 * @return
	 */
	public int findTargetSumWays4(int[] nums, int S) {
		int len = nums.length;
		int[] bag = new int[2001];
		bag[1000 + nums[0]] = 1;
		bag[1000 - nums[0]] += 1;
		for (int i = 1; i < len; i++) {
			int[] nextBag = new int[2001];
			for (int j = 0; j < 2001; j++) {
				if (bag[j] > 0) {
					nextBag[j + nums[i]] += bag[j];
					nextBag[j - nums[i]] += bag[j];
				}
			}
			bag = nextBag;
		}
		return S > 1000 ? 0 : bag[S + 1000];
	}

	public static void main(String[] args) {
		M494 m494 = new M494();
		int[] nums = { 1, 1, 1, 1, 1 };
		System.out.println(m494.findTargetSumWays4(nums, 3));
	}
}
