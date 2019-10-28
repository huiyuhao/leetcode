package leetcode;

public class Four {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[] nums3 = new int[m + n];
		int i = 0, j = 0, k = 0;
		double mid;
		while(i < m && j < n) {
			if(nums1[i] < nums2[j]) {
				nums3[k] = nums1[i];
				i++;
			}else {
				nums3[k] = nums2[j];
				j++;
			}
			k++;
		}
		if(i == m) {
			while(k < (m + n) && j < n){
				nums3[k] = nums2[j];
				j++;
				k++;
			}
		}
		if(j == n) {
			while(k < (m + n) && i < m){
				nums3[k] = nums1[i];
				i++;
				k++;
			}
		}
		if((m + n) % 2 == 0) {
			double a = nums3[(m + n)/2];
			double b = nums3[(m + n)/2 -1];
			mid = (a+b)/2;
		}else {
			mid = nums3[(m + n - 1)/2];
		}
		return mid;
	}
	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		double mid = findMedianSortedArrays(nums1, nums2);
		System.out.println(mid);
	}
}
