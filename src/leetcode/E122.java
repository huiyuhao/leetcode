package leetcode;

public class E122 {
    public int maxProfit(int[] prices) {
    	if(prices.length < 1)
    		return 0;
        int lowPrice = prices[0], highPrice = 0, maxProfits = 0;
        for (int i = 1; i < prices.length - 1; i++) {
			if(prices[i] <= prices[i - 1] && prices[i] <= prices[i + 1]) {
				lowPrice = prices[i];
			}
			if(prices[i] > prices[i - 1] && prices[i] >= prices[i + 1]) {
				highPrice = prices[i];
				maxProfits += highPrice - lowPrice;
			}	
		}
        if(prices[prices.length - 1] > lowPrice && prices[prices.length - 1] > prices[prices.length - 2]) {
        	maxProfits += prices[prices.length - 1] - lowPrice;
        }
        return maxProfits;     
    }
    
    //贪心算法，只要当天的比昨天的价格高就可以选择在当天卖出（同一天可以卖出在昨天的再买入今天的）
    public int maxProfit2(int[] prices) {
    	int maxProfits = 0;
    	for (int i = 1; i < prices.length; i++) {
			if(prices[i] > prices[i - 1]) {
				maxProfits += prices[i] - prices[i - 1];
			}
		}
    	return maxProfits;
    }
    
    public int maxProfit3(int[] prices){

        // 数组为空特例
        if (prices.length == 0) return 0;

        int i=0, j=1, ans=0;

        while (j<prices.length){

            if (prices[j] < prices[j-1]) {
                ans += prices[j-1] - prices[i];
                i = j;
            };
            j++;
        }

        // 判断如果最后一位也是递增的情况做最后一次检查，例如 数组最后三位为 [...,3,4,5] 则没有j位<j-1位的判断
        if (prices[j-1] - prices[i] >0) ans += prices[j-1] - prices[i];
        return ans;
    }

    public static void main(String[] args) {
		int[] prices = {0,5,5,6,2,1,1,3};
		E122 e122 = new E122();
		int maxProfits = e122.maxProfit3(prices);
		System.out.println(maxProfits);
	}
}
