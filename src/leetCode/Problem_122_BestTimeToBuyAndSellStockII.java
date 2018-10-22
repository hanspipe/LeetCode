package leetCode;

public class Problem_122_BestTimeToBuyAndSellStockII {
	
	// Peak Valley Approach
	public int maxProfit1(int[] prices) {
		int i = 0;
		int vally = prices[0];
		int peak = prices[0];
		int maxProfit = 0;
		while(i < prices.length - 1) {
			while(i < prices.length - 1 && prices[i] >= prices[i + 1])
				i++;
			vally = prices[i];
			while(i < prices.length - 1 && prices[i] <= prices[i + 1])
				i++;
			peak = prices[i];
			maxProfit += peak - vally;
		}
		return maxProfit;
	}
}
