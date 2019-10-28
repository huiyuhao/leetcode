package leetcode;

import java.util.ArrayList;
import java.util.List;

public class E118 {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if(numRows == 0) {
			return triangle;
		}
		
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);
		
		for (int i = 1; i < numRows; i++) {
			triangle.add(new ArrayList<>());
			List<Integer> preRow = triangle.get(i - 1);
			triangle.get(i).add(1);
			for (int j = 1; j < i; j++) {
				triangle.get(i).add(preRow.get(j - 1) + preRow.get(j));
			}
			triangle.get(i).add(1);
		}
		return triangle;
	}
	
	public static void main(String[] args) {
		int numRows = 0;
		List<List<Integer>> triangle = generate(numRows);
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(triangle.get(i).get(j));
			}
			System.out.println();
		}
	}
}
