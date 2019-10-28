package leetcode;

public class E559 {
	
	public int maxDepth(Node root) {
		int maxDep = 0;
		if (root == null)
			return 0;
		else
			for (int i = 0; i < root.children.size(); i++) {
				maxDep = Math.max(maxDepth(root.children.get(i)), maxDep);
			}
		return maxDep + 1;
	}
}
