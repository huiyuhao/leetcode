package leetcode;

public class E66 {
	public static int[] plusOne(int[] digits) {
		int len = digits.length;
		if (digits[len - 1] != 9) {
			digits[len - 1]++;
			return digits;
		}
		int pop = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (i == 0 && digits[i] == 9 && pop == 1) {
				int[] result = new int[len + 1];
				for (int j = 1; j < result.length; j++) {
					result[j] = 0;
				}
				result[0] = 1;
				return result;
			}
			if (digits[i] == 9 && pop == 1) {
				digits[i] = 0;
				pop = 1;
			} else {
				digits[i] = digits[i] + pop;
				pop = 0;
			}
		}
		return digits;
	}

	public static void main(String[] args) {
		int[] digits = { 5, 6, 2, 0, 0, 4, 6, 2, 4, 9 };
		int[] result = plusOne(digits);
		System.out.println(result);
	}
}
