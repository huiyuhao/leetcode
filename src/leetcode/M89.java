package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M89 {
	/**
	 * 自己用格雷码的对称性写的
	 * 
	 * @param n
	 * @return
	 */
	public List<Integer> grayCode(int n) {
		int row = (int) Math.pow(2, n);
		int col = n;
		int[][] s = new int[row][col];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < Math.pow(2, i); j++) {
				s[j][i] = 0;
			}
			for (int j = (int) Math.pow(2, i); j < 2 * Math.pow(2, i); j++) {
				s[j][i] = 1;
			}
			if (Math.pow(2, n) > Math.pow(2, (i + 1))) {
				for (int j = (int) (2 * Math.pow(2, i)); j < 3 * Math.pow(2, i); j++) {
					s[j][i] = 1;
				}
				for (int j = (int) (3 * Math.pow(2, i)); j < 4 * Math.pow(2, i); j++) {
					s[j][i] = 0;
				}
			}
			int l = 1;
			while (((l + 1) * 4 * Math.pow(2, i)) <= Math.pow(2, n)) {
				int index = 0;
				for (int k = (int) (l * 4 * Math.pow(2, i)); k < (l + 1) * 4 * Math.pow(2, i); k++) {
					s[k][i] = s[index][i];
					index++;
				}
				l++;
			}
		}

		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < Math.pow(2, n); i++) {
			int num = 0;
			for (int j = 0; j < n; j++) {
				num += Math.pow(2, j) * s[i][j];
			}
			res.add(num);
		}
		return res;
	}

	/**
	 * 别人的对称，和我上面是一种基础思路，但是好简洁，而且快
	 * 
	 * @param n
	 * @return
	 */
	public List<Integer> grayCode2(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
		int head = 1;
		for (int i = 0; i < n; i++) {
			for (int j = res.size() - 1; j >= 0; j--) {
				res.add(head + res.get(j));
			}
			head <<= 1;
		}
		return res;
	}

	/**
	 * 解法二 直接推导
	 * 解法一我觉得，在不了解格雷码的情况下，还是可以想到的，下边的话，应该是之前了解过格雷码才写出来的。看下维基百科提供的一个生成格雷码的思路。
	 * 
	 * 以二进制为 0
	 * 值的格雷码为第零项，第一项改变最右边的位元，第二项改变右起第一个为1的位元的左边位元，第三、四项方法同第一、二项，如此反复，即可排列出n个位元的格雷码。
	 * 
	 * 以 n = 3 为例。 0 0 0 第零项初始化为 0。 0 0 1 第一项改变上一项最右边的位元 0 1 1 第二项改变上一项右起第一个为 1
	 * 的位元的左边位 0 1 0 第三项同第一项，改变上一项最右边的位元 1 1 0 第四项同第二项，改变最上一项右起第一个为 1 的位元的左边位 1 1 1
	 * 第五项同第一项，改变上一项最右边的位元 1 0 1 第六项同第二项，改变最上一项右起第一个为 1 的位元的左边位 1 0 0
	 * 第七项同第一项，改变上一项最右边的位元 思路有了，代码自然也就出来了。
	 * 
	 * @param n
	 * @return
	 */
	public List<Integer> grayCode3(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
		for (int i = 1; i < 1 << n; i++) {
			int previous = res.get(i - 1);
			if (i % 2 == 1) {
				previous ^= 1;
				res.add(previous);
			} else {
				int temp = previous;
				for (int j = 0; j < n; j++) {
					if ((temp & 1) == 1) {
						previous = previous ^ (1 << (j + 1));
						res.add(previous);
						break;
					}
					temp >>= 1;
				}
			}
		}
		return res;
	}

	/**
	 * 用格雷码的生成公式
	 * 
	 * @param n
	 * @return
	 */
	public List<Integer> grayCode4(int n) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < 1 << n; i++) {
			res.add(i ^ (i >> 1));
		}
		return res;
	}

	public static void main(String[] args) {
		M89 m89 = new M89();
		System.out.println(m89.grayCode(1));
	}
}
