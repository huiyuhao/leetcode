package leetcode;

import java.util.ArrayList;
import java.util.List;

public class E119 {
	public static List<Integer> getRow(int rowIndex) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);
		for (int i = 1; i <= rowIndex; i++) {
			triangle.add(new ArrayList<>());
			List<Integer> preRow = triangle.get(i - 1);
			triangle.get(i).add(1);
			for (int j = 1; j < i; j++) {
				triangle.get(i).add(preRow.get(j - 1) + preRow.get(j));
			}
			triangle.get(i).add(1);
		}
		return triangle.get(rowIndex);
	}

	// 递归
	public static List<Integer> getRow1(int rowIndex) {
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		if (rowIndex == 0)
			return row;
		List<Integer> preRow = getRow(rowIndex - 1);
		for (int i = 1; i < rowIndex; i++) {
			row.add(preRow.get(i - 1) + preRow.get(i));
		}
		row.add(1);
		return row;
	}

	/**
	 * 获取杨辉三角的指定行 
	 * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!) 
	 * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
	 */
	public List<Integer> getRow2(int rowIndex) {
		List<Integer> res = new ArrayList<>(rowIndex + 1);
		long cur = 1;
		for (int i = 0; i <= rowIndex; i++) {
			res.add((int) cur);
			cur = cur * (rowIndex - i) / (i + 1);
		}
		return res;
	}
}
