package leetcode;

public class E235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode pTemp = new TreeNode(p.val); 
		TreeNode qTemp = new TreeNode(q.val);
		pTemp.val = Math.min(p.val, q.val);
		qTemp.val = Math.max(p.val, q.val);
		if (root.left != null && root.val > qTemp.val)
			return lowestCommonAncestor(root.left, pTemp, qTemp);
		if (root.right != null && root.val < pTemp.val)
			return lowestCommonAncestor(root.right, pTemp, qTemp);
		return root;
	}
	
	public static void main(String[] args) {
		E235 e235 = new E235();
		Integer[] nums = {5,3,6,2,4,null,null,1};
		TreeNode root = ConstructTree.constructTree(nums);
		TreeNode p = new TreeNode(6);
		TreeNode q = new TreeNode(1); 
		TreeNode result = e235.lowestCommonAncestor(root, p, q);
		System.out.println(result.val);
	}
}
