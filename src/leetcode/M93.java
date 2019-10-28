package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M93 {
	/**
	 * ’Ê «±©¡¶∞°
	 * 
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses(String s) {
		int len = s.length();
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder(s);
		for (int i = 1; i < 4; i++) {
			for (int j = i + 1; j < len - 1 && j < i + 4; j++) {
				for (int k = j + 1; k < len && k < j + 4; k++) {
					if (len - k > 3 || i > 1 && sb.charAt(0) == '0' || j - i > 1 && sb.charAt(i) == '0'
							|| k - j > 1 && sb.charAt(j) == '0' || len - k > 1 && sb.charAt(k) == '0')
						continue;
					if (Integer.valueOf(sb.substring(0, i)) <= 255 && Integer.valueOf(sb.substring(i, j)) <= 255
							&& Integer.valueOf(sb.substring(j, k)) <= 255
							&& Integer.valueOf(sb.substring(k, len)) <= 255) {
						sb.insert(i, '.');
						sb.insert(j + 1, '.');
						sb.insert(k + 2, '.');
						res.add(new String(sb));
						sb.deleteCharAt(i);
						sb.deleteCharAt(j);
						sb.deleteCharAt(k);
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		M93 m93 = new M93();
		System.out.println(m93.restoreIpAddresses("010010"));
	}
}
