package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M17 {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return result;
    	StringBuilder sb = new StringBuilder();
    	int index = 0;
        recursion(index, digits, sb, result);
        return result;
    }
	
	public void recursion(int index, String digits, StringBuilder sb, List<String> result) {
		char[] eng = {'0', '0', '0', '0'};
		switch (digits.charAt(index)) {
		case '2':
			eng[0] = 'a';
			eng[1] = 'b';
			eng[2] = 'c';
			break;
		case '3':
			eng[0] = 'd';
			eng[1] = 'e';
			eng[2] = 'f';
			break;
		case '4':
			eng[0] = 'g';
			eng[1] = 'h';
			eng[2] = 'i';
			break;
		case '5':
			eng[0] = 'j';
			eng[1] = 'k';
			eng[2] = 'l';
			break;
		case '6':
			eng[0] = 'm';
			eng[1] = 'n';
			eng[2] = 'o';
			break;
		case '7':
			eng[0] = 'p';
			eng[1] = 'q';
			eng[2] = 'r';
			eng[3] = 's';
			break;
		case '8':
			eng[0] = 't';
			eng[1] = 'u';
			eng[2] = 'v';
			break;
		case '9':
			eng[0] = 'w';
			eng[1] = 'x';
			eng[2] = 'y';
			eng[3] = 'z';
			break;

		}
		int i = 0;
		while (i < eng.length && eng[i] != '0') {
			sb.append(eng[i]);
			
			if(index < digits.length() - 1) {
				index++;
				recursion(index, digits, sb, result);
				index--;
			}
			if (sb.length() == digits.length())
				result.add(sb.toString());
			sb.deleteCharAt(index);
			i++;
		}
	}
	
	/**
	 *下面这是官方题解
	 */
	Map<String, String> phone = new HashMap<String, String>() {{
	    put("2", "abc");
	    put("3", "def");
	    put("4", "ghi");
	    put("5", "jkl");
	    put("6", "mno");
	    put("7", "pqrs");
	    put("8", "tuv");
	    put("9", "wxyz");
	  }};

	  List<String> output = new ArrayList<String>();

	  public void backtrack(String combination, String next_digits) {
	    // if there is no more digits to check
	    if (next_digits.length() == 0) {
	      // the combination is done
	      output.add(combination);
	    }
	    // if there are still digits to check
	    else {
	      // iterate over all letters which map 
	      // the next available digit
	      String digit = next_digits.substring(0, 1);
	      String letters = phone.get(digit);
	      for (int i = 0; i < letters.length(); i++) {
	        String letter = phone.get(digit).substring(i, i + 1);
	        // append the current letter to the combination
	        // and proceed to the next digits
	        backtrack(combination + letter, next_digits.substring(1));
	      }
	    }
	  }

	  public List<String> letterCombinations2(String digits) {
	    if (digits.length() != 0)
	      backtrack("", digits);
	    return output;
	  }

	
	
	public static void main(String[] args) {
		M17 m17 = new M17();
		String digits = "";
		System.out.println(m17.letterCombinations(digits));
	}
}
