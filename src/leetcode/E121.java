package leetcode;

public class E121 {
	public int maxProfit(int[] prices) {
		int maxProfits = 0, profits = 0, highPrice = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			highPrice = 0;
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] > highPrice && prices[j] > prices[i]) {
					profits = prices[j] - prices[i];
					maxProfits = Math.max(maxProfits, profits);
					highPrice = prices[j];
				}
			}
		}
		return maxProfits;
	}
	
	public int maxProfit2(int[] prices) {
		int maxProfits = 0, highPrice = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			highPrice = 0;
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] > highPrice && prices[j] > prices[i] && prices[j] - prices[i] > maxProfits) {
					maxProfits = prices[j] - prices[i];
					highPrice = prices[j];
				}
			}
		}
		return maxProfits;	
	}
	
	public int maxProfit3(int[] prices) {
		int maxProfits = 0, lowPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] < lowPrice) {
				lowPrice = prices[i];
			}else if(prices[i] - lowPrice > maxProfits) {
				maxProfits = prices[i] - lowPrice;
			}
		}
		return maxProfits;
	}
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		E121 e121 = new E121();
		int maxProfits = e121.maxProfit3(prices);
		System.out.println(maxProfits);
	}
}
