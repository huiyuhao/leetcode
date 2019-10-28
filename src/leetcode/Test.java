package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<List<Integer>> result1 = new ArrayList<>();
		List<List<Integer>> result2 = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		temp.add(2);
		temp.add(3);
		result1.add(temp);
		result2.add(new ArrayList<>(temp));
		temp.remove(temp.size() - 1);
		
		
	}
}
