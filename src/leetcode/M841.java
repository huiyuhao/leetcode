package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M841 {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int num = rooms.size();
		int[] visited = new int[num];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		visited[0] = 1;
		while (!queue.isEmpty()) {
			int curRoom = queue.poll();
			List<Integer> roomKeys = rooms.get(curRoom);
			for (int i = 0; i < roomKeys.size(); i++)
				if (visited[roomKeys.get(i)] == 0) {
					queue.add(roomKeys.get(i));
					visited[roomKeys.get(i)] = 1;
				}
		}
		for (int i : visited)
			if (i == 0)
				return false;
		return true;
	}

	/**
	 * ตÝน้
	 * 
	 * @param rooms
	 * @return
	 */
	public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
		int[] visited = new int[rooms.size()];
		visited[0] = 1;
		helper(rooms, visited, 0);
		for (int i : visited)
			if (i == 0)
				return false;
		return true;
	}

	public void helper(List<List<Integer>> rooms, int[] visited, int index) {
		List<Integer> roomKeys = rooms.get(index);
		for (Integer i : roomKeys) {
			if (visited[i] == 0) {
				visited[i] = 1;
				helper(rooms, visited, i);
			}
		}
	}
}
