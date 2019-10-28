package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0;
        int i = 0;
        recursion(n, left, right, result, i + 1, sb);
        return result;
    }
    
    public void recursion(int n, int left, int right, List<String> result, int i, StringBuilder sb) {
    	if (i <= 2 * n) {
    		for (int j = 0; j < 2; j++) {
				if(left < n && left >= 0 && j == 0) {
					sb.append('(');
					left++;
					recursion(n, left, right, result, i + 1, sb);
					sb.deleteCharAt(sb.length() - 1);
					left--;
				}else if (right < n && right >= 0  && right < left && j == 1){
					sb.append(')');
					right++;
					recursion(n, left, right, result, i + 1, sb);
					sb.deleteCharAt(sb.length() - 1);
					right--;
				}
			}
    	}else {
    		result.add(sb.toString());
    	}
    }
    
    /**
     * 官方题解 暴力法
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    /**
     * 官方题解  闭合数  很巧妙  但难以理解
     * @param n
     * @return
     */
    public List<String> generateParenthesis3(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis3(c))
                    for (String right: generateParenthesis3(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    
    public static void main(String[] args) {
		M22 m22 = new M22();
		int n = 2;
		System.out.println(m22.generateParenthesis3(n));
	}
}
