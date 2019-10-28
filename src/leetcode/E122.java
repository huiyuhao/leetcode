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
    
    //̰���㷨��ֻҪ����ı�����ļ۸�߾Ϳ���ѡ���ڵ���������ͬһ�������������������������ģ�
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

        // ����Ϊ������
        if (prices.length == 0) return 0;

        int i=0, j=1, ans=0;

        while (j<prices.length){

            if (prices[j] < prices[j-1]) {
                ans += prices[j-1] - prices[i];
                i = j;
            };
            j++;
        }

        // �ж�������һλҲ�ǵ�������������һ�μ�飬���� ���������λΪ [...,3,4,5] ��û��jλ<j-1λ���ж�
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
