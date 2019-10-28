package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M89 {
	/**
	 * �Լ��ø�����ĶԳ���д��
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
	 * ���˵ĶԳƣ�����������һ�ֻ���˼·�����Ǻü�࣬���ҿ�
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
	 * �ⷨ�� ֱ���Ƶ�
	 * �ⷨһ�Ҿ��ã��ڲ��˽�����������£����ǿ����뵽�ģ��±ߵĻ���Ӧ����֮ǰ�˽���������д�����ġ�����ά���ٿ��ṩ��һ�����ɸ������˼·��
	 * 
	 * �Զ�����Ϊ 0
	 * ֵ�ĸ�����Ϊ�������һ��ı����ұߵ�λԪ���ڶ���ı������һ��Ϊ1��λԪ�����λԪ�������������ͬ��һ�������˷������������г�n��λԪ�ĸ����롣
	 * 
	 * �� n = 3 Ϊ���� 0 0 0 �������ʼ��Ϊ 0�� 0 0 1 ��һ��ı���һ�����ұߵ�λԪ 0 1 1 �ڶ���ı���һ�������һ��Ϊ 1
	 * ��λԪ�����λ 0 1 0 ������ͬ��һ��ı���һ�����ұߵ�λԪ 1 1 0 ������ͬ�ڶ���ı�����һ�������һ��Ϊ 1 ��λԪ�����λ 1 1 1
	 * ������ͬ��һ��ı���һ�����ұߵ�λԪ 1 0 1 ������ͬ�ڶ���ı�����һ�������һ��Ϊ 1 ��λԪ�����λ 1 0 0
	 * ������ͬ��һ��ı���һ�����ұߵ�λԪ ˼·���ˣ�������ȻҲ�ͳ����ˡ�
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
	 * �ø���������ɹ�ʽ
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
