package leetcode;

import java.util.List;

public class M120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int deep = triangle.size();
		int[] path = new int[deep];
		for (int i = deep - 1; i >= 0; i--)
			for (int j = 0; j <= i; j++)
				if (i == deep - 1)
					path[j] = triangle.get(i).get(j);
				else
					path[j] = triangle.get(i).get(j) + Math.min(path[j], path[j + 1]);
		return path[0];
	}
}
