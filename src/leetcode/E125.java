package leetcode;

public class E125 {

	/*
	 * ��������˫ָ�룬���м��жϣ� ������������ĸ���ַ��� ����ĸȫ��ת��ΪСд�壬֮���жϡ�
	 */
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
				i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
				j--;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public boolean isPalindrome2(String s) {
		if (s == null || s.length() == 0)
			return true;
		for (int i = 0, j = s.length() - 1; i <= j;) {
			char p = s.charAt(i);
			char q = s.charAt(j);
			// p��Ϊ���ֻ��ַ�ʱi�����ҵ���һ����������
			if (!(p >= '0' && p <= '9' || p >= 'a' && p <= 'z' || p >= 'A' && p <= 'Z')) {
				i++;
				continue;
			}
			// p��Ϊ���ֻ��ַ�ʱi��ǰ�ҵ���һ����������
			if (!(q >= '0' && q <= '9' || q >= 'a' && q <= 'z' || q >= 'A' && q <= 'Z')) {
				j--;
				continue;
			}
			// ��pq��ָ�ַ�Ϊ���ֺ���ĸʱ�űȽϣ�����ַ������ֲ�������̷���false
			// �ڲ�p==q || (p-q==32||q-p==32&&(p>=65&&q>=65))�жϵ��Ƿ�Ϊ���ֻ��ַ��������Ǵ�Сд�������
			if (!(p == q || (p - q == 32 || q - p == 32 && (p >= 65 && q >= 65)))) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

}
