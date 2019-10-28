package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class M179 {
	/**
	 * 
	 * @author yanghao
	 *
	 */
	private class LargerNumberComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			String order1 = s1 + s2;
			String order2 = s2 + s1;
			return order2.compareTo(order1);
		}

	}

	public String largestNumber(int[] nums) {
		String[] str = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			str[i] = String.valueOf(nums[i]);
		Arrays.sort(str, new LargerNumberComparator());
		if (str[0].equals("0"))
			return "0";
		String res = new String();
		for (String s : str)
			res += s;
		return res;
	}

	public static void main(String[] args) {
		M179 m179 = new M179();
		System.out.println(m179.largestNumber(new int[] { 0, 0 }));
	}

}
