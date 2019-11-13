package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class M133 {
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
		}

		public Node(int _val, List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	/**
	 * 用HashMap来存储旧节点和新建节点的关系，用Set来存储走过的节点，用栈来存储将要走的节点，
	 * 每个新节点先赋值，在随后遍历旧节点的邻居时，再把新建好的的邻居链表赋给它
	 * 
	 * @param node
	 * @return
	 */
	public Node cloneGraph(Node node) {
		Node res = new Node();
		res.val = node.val;
		Stack<Node> stack = new Stack<>();
		HashMap<Node, Node> map = new HashMap<>();
		Set<Node> set = new HashSet<>();
		set.add(node);
		stack.push(node);
		map.put(node, res);
		while (!stack.isEmpty()) {
			Node cur1 = stack.pop();
			Node cur2 = map.get(cur1);
			List<Node> neighbors = new ArrayList<>();
			for (Node nei : cur1.neighbors) {
				if (set.contains(nei)) {
					neighbors.add(map.get(nei));
					continue;
				}
				Node temp = new Node();
				temp.val = nei.val;
				neighbors.add(temp);
				stack.push(nei);
				map.put(nei, temp);
				set.add(nei);
			}
			cur2.neighbors = neighbors;
		}
		return res;
	}

	/**
	 * 用map.containsKey来检查是不是走过就好了，不用新建Set 用队列写BFS就是把这里的栈换成队列，就不写了
	 * 
	 * @param node
	 * @return
	 */
	public Node cloneGraph2(Node node) {
		Node res = new Node();
		res.val = node.val;
		Stack<Node> stack = new Stack<>();
		HashMap<Node, Node> map = new HashMap<>();
		stack.push(node);
		map.put(node, res);
		while (!stack.isEmpty()) {
			Node cur1 = stack.pop();
			Node cur2 = map.get(cur1);
			List<Node> neighbors = new ArrayList<>();
			for (Node nei : cur1.neighbors) {
				if (map.containsKey(nei)) {
					neighbors.add(map.get(nei));
					continue;
				}
				Node temp = new Node();
				temp.val = nei.val;
				neighbors.add(temp);
				stack.push(nei);
				map.put(nei, temp);
			}
			cur2.neighbors = neighbors;
		}
		return res;
	}

	/**
	 * 拿递归写DFS
	 * 
	 * @param node
	 * @return
	 */
	public Node cloneGraph3(Node node) {
		Node res = new Node();
		res.val = node.val;
		HashMap<Node, Node> map = new HashMap<>();
		map.put(node, res);
		dfs(node, map);
		return res;
	}

	public void dfs(Node node, HashMap<Node, Node> map) {
		List<Node> neighbors = new ArrayList<>();
		for (Node nei : node.neighbors) {
			if (map.containsKey(nei)) {
				neighbors.add(map.get(nei));
			} else {
				Node temp = new Node();
				temp.val = nei.val;
				neighbors.add(temp);
				map.put(nei, temp);
				dfs(nei, map);
			}
		}
		map.get(node).neighbors = neighbors;
	}

	// 同样都是递归DFS，大神屌屌屌
	private HashMap<Node, Node> map = new HashMap<>();

	public Node cloneGraph4(Node node) {
		return clone(node);
	}

	public Node clone(Node node) {
		if (map.containsKey(node))
			return map.get(node);
		Node clone = new Node(node.val, new ArrayList<>());
		map.put(node, clone);
		for (Node n : node.neighbors)
			clone.neighbors.add(clone(n));
		return clone;
	}
}
