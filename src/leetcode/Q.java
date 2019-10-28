package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q {
	public int game(int[] guess, int[] answer) {
		int sum = 0;
		for (int i = 0; i < answer.length; i++) {
			if (guess[i] == answer[i])
				sum++;
		}
		return sum;
	}

	public int[] fraction(int[] cont) {
		int a, b;
		a = cont[cont.length - 1];
		b = 1;
		for (int i = cont.length - 2; i >= 0; i--) {
			int temp = b;
			b = a;
			a = temp + cont[i] * b;
		}
		return new int[] { a, b };
	}

	/**
	 * ³¬Ê±
	 * 
	 * @param command
	 * @param obstacles
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean robot1(String command, int[][] obstacles, int x, int y) {
		int a = 0, b = 0;
		while (a != x || b != y) {
			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'U')
					b++;
				else
					a++;
				for (int j = 0; j < obstacles.length; j++) {
					if (a == obstacles[j][0] && b == obstacles[j][1])
						return false;
				}
			}
		}
		return true;
	}

	public boolean robot(String command, int[][] obstacles, int x, int y) {
		int a = 0, b = 0;
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == 'U')
				b++;
			else
				a++;
		}
		int now = x / a;
		int nowX = a * now;
		int nowY = b * now;
		boolean flag = false;
		for (int i = 0; i < command.length(); i++) {
			if (nowX == x && nowY == y)
				flag = true;
			if (command.charAt(i) == 'U')
				nowY++;
			else
				nowX++;
		}
		if (flag == false)
			return false;
		for (int i = 0; i < obstacles.length; i++) {
			now = obstacles[i][0] / a;
			nowX = a * now;
			nowY = b * now;
			for (int j = 0; j < command.length(); j++) {
				if (nowX > x || nowX > y)
					continue;
				if (nowX == obstacles[i][0] && nowY == obstacles[i][1] && (nowX <= x && nowY <= y))
					return false;
				if (command.charAt(j) == 'U')
					nowY++;
				else
					nowX++;
			}
		}
		return true;
	}
	
    public int domino(int n, int m, int[][] broken) {
        boolean htsf = true;
        
    }
    
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
    	Arrays.sort(leadership);
        for (int i = 0; i < leadership.length; i++) {
			
		}
    }

	public static void main(String[] args) {
		Q q1 = new Q();
		int[][] obstacles = { { 5, 2 }, { 0, 2 } };
		boolean flag = q1.robot("URR", obstacles, 4, 2);
		System.out.println(flag ? "true" : "false");

	}
}
