package leetcode;

import java.util.ArrayList;
import java.util.List;

public class M54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		// ��state = 0,1,2,3����ʾ��Ҫ���¹գ��������ϣ������ĸ�״̬����ʼ��0����Ҫ����
		int state = 0;
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return res;
		// row��ʾ����������column��ʾ��������
		int row = matrix.length;
		int column = matrix[0].length;
		// �������ĸ������Ƿ�ֹԽ���
		int rowFlagBegin = 0, columnFlagBegin = 0;
		int rowFlagEnd = row - 1, columnFlagEnd = column - 1;
		int i = 0;
		int x = 0, y = 0;
		while (i < row * column) {
			res.add(matrix[x][y]);
			if (state == 0)
				if (y == columnFlagEnd) {
					x++;
					state = 1;
					rowFlagBegin++;
				} else
					y++;
			else if (state == 1)
				if (x == rowFlagEnd) {
					y--;
					state = 2;
					columnFlagEnd--;
				} else
					x++;
			else if (state == 2)
				if (y == columnFlagBegin) {
					x--;
					state = 3;
					rowFlagEnd--;
				} else
					y--;
			else if (state == 3)
				if (x == rowFlagBegin) {
					y++;
					state = 0;
					columnFlagBegin++;
				} else
					x--;
			i++;
		}
		return res;
	}

	/**
	 * �������if�оٻ�����swith,�����������һЩ
	 * 
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder2(int[][] matrix) {
		// ��state = 0,1,2,3����ʾ��Ҫ���¹գ��������ϣ������ĸ�״̬����ʼ��0����Ҫ����
		int state = 0;
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return res;
		// row��ʾ����������column��ʾ��������
		int row = matrix.length;
		int column = matrix[0].length;
		// �������ĸ������Ƿ�ֹԽ���
		int rowFlagBegin = 0, columnFlagBegin = 0;
		int rowFlagEnd = row - 1, columnFlagEnd = column - 1;
		int i = 0;
		int x = 0, y = 0;
		while (i < row * column) {
			res.add(matrix[x][y]);
			switch (state) {
			case 0:
				if (y == columnFlagEnd) {
					x++;
					state = 1;
					rowFlagBegin++;
				} else
					y++;
				break;
			case 1:
				if (x == rowFlagEnd) {
					y--;
					state = 2;
					columnFlagEnd--;
				} else
					x++;
				break;
			case 2:
				if (y == columnFlagBegin) {
					x--;
					state = 3;
					rowFlagEnd--;
				} else
					y--;
				break;
			case 3:
				if (x == rowFlagBegin) {
					y++;
					state = 0;
					columnFlagBegin++;
				} else
					x--;
				break;
			}
			i++;
		}
		return res;
	}
}
