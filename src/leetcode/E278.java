package leetcode;

public class E278 extends VersionControl {
	public int firstBadVersion(int n) {
		int begin = 1;
		int end = n;
		while (begin < end) {
			int mid = begin + (end - begin) / 2;
			if (isBadVersion(mid))
				end = mid;
			else
				begin = mid + 1;
		}
		return begin;
	}
}
