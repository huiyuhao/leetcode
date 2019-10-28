package leetcode;

public class M134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
//		int countGas = 0;
//		int countCost = 0;
//		for (int c : cost) {
//			countCost += c;
//		}
//		for (int g : gas) {
//			countGas += g;
//		}
//		if (countGas < countCost)
//			return -1;

		int len = cost.length;
		for (int i = 0; i < len; i++) {
			int num = 0;
			int tank = gas[i];
			while (num < len) {
				if ((i + num) >= len) {
					tank = tank - cost[i + num - len];
					if (tank >= 0)
						tank = tank + gas[i + num - len + 1];
					else
						break;
				} else {
					tank = tank - cost[i + num];
					if (tank >= 0) {
						if (i + num + 1 >= len)
							tank = tank + gas[i + num - len + 1];
						else
							tank = tank + gas[i + num + 1];
					} else
						break;
				}
				num++;
				if (num == len)
					return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int len = cost.length;
		for (int i = 0; i < len; i++) {
			int tank = 0;
			boolean flag = true;
			int num = 0;
			for (int j = i; j < cost.length; j++) {
				tank = tank + gas[j] - cost[j];
				if (tank < 0) {
					flag = false;
					break;
				} else
					num++;
			}
			if (flag)
				for (int j = 0; j < i; j++) {
					tank = tank + gas[j] - cost[j];
					if (tank < 0)
						flag = false;
					else
						num++;
				}
			if (num == len)
				return i;
		}
		return -1;
	}

	/**
	 * 真滴牛批，贪心算法
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit3(int[] gas, int[] cost) {
		int all = 0;
		int tank = 0;
		int index = 0;
		for (int i = 0; i < cost.length; i++) {
			tank += gas[i] - cost[i];
			all += gas[i] - cost[i];
			if (tank < 0) {
				tank = 0;
				index = i + 1;
			}
		}
		return all >= 0 ? index : -1;
	}

}
