package leetcode;

import java.util.Arrays;

public class E88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] temp = new int[nums1.length];
		int i = 0, j = 0, k = 0;
		while (k < nums1.length) {
			if(j >= n) {
				temp[k] = nums1[i];
				i++;
				k++;
				continue;
			}
			if(i >= m) {
				temp[k] = nums2[j];
				j++;
				k++;
				continue;
			}	
			if (nums1[i] < nums2[j]) {
				temp[k] = nums1[i];
				i++;
			}else if(nums1[i] >= nums2[j]){
				temp[k] = nums2[j];
				j++;
			}
			k++;
		}
		for (int l = 0; l < temp.length; l++) {
			nums1[l] = temp[l];
		}
	}
	
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
	    System.arraycopy(nums2, 0, nums1, m, n);
	    Arrays.sort(nums1);
	  }
	
	public void merge3(int[] nums1, int m, int[] nums2, int n) {
		int p = m - 1;
		int q = n - 1;
		int k = m + n - 1;
		while(p >= 0 && q >= 0) {
			nums1[k--] = nums1[p] > nums2[q] ? nums1[p--] : nums2[q--];
		}
		if(q >= 0) {
			System.arraycopy(nums2, 0, nums1, 0, q + 1);
		}
	}

	
	public static void main(String[] args) {
		int[] nums1 = {0};
		int[] nums2 = {1};
		int m = 0, n = 1;
		E88 e88 = new E88();
		e88.merge3(nums1, m, nums2, n);
		for (int num : nums1) {
			System.out.println(num);
		}
	}
}
