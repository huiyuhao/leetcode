package leetcode;

import java.util.ArrayList;
import java.util.List;

public class E257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null)
    		return result;
        String temp = "";
        helper(root, result, temp);
        return result;
        	
    }
    public void helper(TreeNode root, List<String> result, String temp) {
    	temp += root.val + "->";
    	if(root.left == null && root.right == null) {
    		result.add(new String(temp.substring(0, temp.length() - 2)));
    	}
    	if(root.left != null)
    		helper(root.left, result, temp);
    	if(root.right != null)
    		helper(root.right, result, temp);
    }
}
