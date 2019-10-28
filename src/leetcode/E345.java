package leetcode;

import java.util.HashSet;
import java.util.Set;

public class E345 {
	public String reverseVowels(String s) {
		int i = 0, j = s.length() - 1;
		String temp;
		StringBuilder sb = new StringBuilder(s);
		while (i < j) {
			while (i < j && sb.charAt(i) != 'a' && sb.charAt(i) != 'o' && sb.charAt(i) != 'e' && sb.charAt(i) != 'i'
					&& sb.charAt(i) != 'u' && sb.charAt(i) != 'A' && sb.charAt(i) != 'O' && s.charAt(i) != 'E'
					&& sb.charAt(i) != 'I' && sb.charAt(i) != 'U')
				i++;
			while (i < j && sb.charAt(j) != 'a' && sb.charAt(j) != 'o' && sb.charAt(j) != 'e' && sb.charAt(j) != 'i'
					&& sb.charAt(j) != 'u' && sb.charAt(j) != 'A' && sb.charAt(j) != 'O' && sb.charAt(j) != 'E'
					&& sb.charAt(j) != 'I' && sb.charAt(j) != 'U')
				j--;
			temp = sb.substring(i, i + 1);
			sb.replace(i, i + 1, sb.substring(j, j + 1));
			sb.replace(j, j + 1, temp);
			i++;
			j--;
		}
		return sb.toString();
	}

	public String reverseVowels2(String s) {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('o');
		set.add('e');
		set.add('i');
		set.add('u');
		set.add('A');
		set.add('O');
		set.add('E');
		set.add('I');
		set.add('U');
		String temp;
		StringBuilder sb = new StringBuilder(s);
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !set.contains(sb.charAt(i)))
				i++;
			while (i < j && !set.contains(sb.charAt(j)))
				j--;
			temp = sb.substring(i, i + 1);
			sb.replace(i, i + 1, sb.substring(j, j + 1));
			sb.replace(j, j + 1, temp);
			i++;
			j--;
		}
		return sb.toString();
	}
	
	//前面两种太慢了
	public String reverseVowels3(String s) {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('o');
		set.add('e');
		set.add('i');
		set.add('u');
		set.add('A');
		set.add('O');
		set.add('E');
		set.add('I');
		set.add('U');
		char temp;
		char[] ch = s.toCharArray();
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !set.contains(ch[i]))
				i++;
			while (i < j && !set.contains(ch[j]))
				j--;
			temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}
		return String.valueOf(ch);
	}

	public static void main(String[] args) {
		E345 e345 = new E345();
		String s = "hello";
		System.out.println(e345.reverseVowels3(s));

	}
}
