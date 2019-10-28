package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M5240 {
	public int maxLength(List<String> arr) {
		Set<Character> set = new HashSet<>();
		return helper(arr, set, 0, arr.size(), 0);
	}

	public int helper(List<String> arr, Set<Character> set, int index, int len, int max) {
		for (int i = index; i < len; i++) {
			String s = arr.get(i);
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (set.contains(c)) {
					for (int k = 0; k < j; k++)
						set.remove(s.charAt(k));
					max = Math.max(max, helper(arr, set, index + 1, len, max));
					return max;
				} else
					set.add(c);
			}
			max = Math.max(max, helper(arr, set, index + 1, len, max));
			max = Math.max(max, set.size());
			for (int k = 0; k < s.length(); k++)
				set.remove(s.charAt(k));
		}
		return max;
	}

	public static void main(String[] args) {
		M5240 m5240 = new M5240();
		List<String> arr = Arrays.asList("cusy", "s", "imelfbpuoawkrq", "roxckjm", "vkaxcbespwotzq", "jrnhyslwbifteqox",
				"fnisjhckr", "ubvpwtzxh", "sgxkqdlw", "hzsngeotfxbcm", "zhrextvndpcmbql", "bdfxez", "rzgnbf", "hbw",
				"cohurlnjqpefzayig", "xoqgyjsm");
		System.out.println(m5240.maxLength(arr));
	}
}
