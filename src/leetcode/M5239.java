package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M5239 {
	public List<Integer> circularPermutation(int n, int start) {
		List<Integer> res = new ArrayList<Integer>();
		int site = -1;
		for (int i = 0; i < Math.pow(2, n); i++)
			if ((i ^ (i >> 1)) == start) {
				site = i;
				break;
			}
		if (site == -1)
			return res;
		for (int i = site; i < Math.pow(2, n); i++)
			res.add(i ^ (i >> 1));
		for (int i = 0; i < site; i++)
			res.add(i ^ (i >> 1));
		return res;
	}
}
