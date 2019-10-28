package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M94 {
	/**
	 * �ݹ�
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		return helper(root, new ArrayList<Integer>());
	}

	public List<Integer> helper(TreeNode root, List<Integer> temp) {
		if (root != null) {
			helper(root.left, temp);
			temp.add(root.val);
			helper(root.right, temp);
		}
		return temp;
	}

	/**
	 * ����
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null)
			return result;
		TreeNode current = root;
		while (!stack.isEmpty() || current != null) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			result.add(current.val);
			current = current.right;
		}
		return result;
	}

	/**
     * Ī��˹����  ����������
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	TreeNode current = root;
    	TreeNode pre;
    	while (current != null) {
    		if(current.left == null) {  //���û����ڵ㣬�Ϳ�ʼ�������
    			result.add(current.val);
    			current = current.right;
    		}
    		else {
    			pre = current.left;  
    			while(pre.right != null)
    				pre = pre.right;  //�ҵ����ڵ��������ϵ�����Ҷ�ӽڵ�
    			pre.right = current;  //�Ѹ��ڵ����  ���ڵ��������ϵ�����Ҷ�ӽڵ�  ���ҽڵ���
    			TreeNode temp = current;  //�ݴ�һ�µ�ǰ���ڵ㣬��Ϊ��һ��Ҫ�������ڵ㣬���Ǹ��ڵ��������Ҫ����
    			current = current.left;  //�����ڵ㻻Ϊ  ԭ���ڵ����ڵ�
    			temp.left = null;  //��ԭ���ڵ������������
    		}
    	}
    	return result;
    }
}
