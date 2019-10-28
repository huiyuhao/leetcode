package leetcode;

public class E292 {
	public boolean canWinNim(int n) {
		if (n % 4 == 0)
			return false;
		return true;
	}

	public boolean canWinNim2(int n) {
		return n % 4 == 0 ? false : true;
	}
}
