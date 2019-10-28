package leetcode;

public class E14 {
    public String longestCommonPrefix(String[] strs) {
    	String result = "";
    	if(strs.length < 1)
    		return result;
    	int flag = 0, endIndex = 0;
        for (int i = 0; i < strs[0].length(); i++) {
        	for (int j = 1; j < strs.length; j++) {
        		if(i >= strs[j].length()) {
        			endIndex--;
        			break;
        		}
				if(strs[0].charAt(i) != strs[j].charAt(i)) {
					flag = 1;
					break;
				}
			}
        	if(flag == 1) {
        		result = strs[0].substring(0, endIndex);
        		return result;
        	}
        	endIndex++;
		}
        result = strs[0].substring(0, endIndex);
        return result;
    }
    
    public String longestCommonPrefix2(String[] strs) {
    	if(strs.length == 0) return "";
    	String prefix = strs[0];
    	for(int i = 1; i < strs.length; i++) {
    		while(strs[i].indexOf(prefix) != 0) {
    			prefix = prefix.substring(0, prefix.length() - 1);
    			if (prefix.isEmpty()) return "";
    		}
    	}
    	return prefix;
    }
    
    public static void main(String[] args) {
		E14 e14 = new E14();
		String[] strs = {"aa","a"};
		String result = e14.longestCommonPrefix2(strs);
		result.toString();
		System.out.println(result);
	}
}
