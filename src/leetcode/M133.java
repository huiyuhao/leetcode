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
	 * ��HashMap���洢�ɽڵ���½��ڵ�Ĺ�ϵ����Set���洢�߹��Ľڵ㣬��ջ���洢��Ҫ�ߵĽڵ㣬
	 * ÿ���½ڵ��ȸ�ֵ�����������ɽڵ���ھ�ʱ���ٰ��½��õĵ��ھ���������
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
	 * ��map.containsKey������ǲ����߹��ͺ��ˣ������½�Set �ö���дBFS���ǰ������ջ���ɶ��У��Ͳ�д��
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
	 * �õݹ�дDFS
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

	// ͬ�����ǵݹ�DFS������ŌŌ�
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
