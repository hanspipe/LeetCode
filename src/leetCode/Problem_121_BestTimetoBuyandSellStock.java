package leetCode;

public class Problem_121_BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0; 
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < minPrice)
				minPrice = prices[i];
			else if(prices[i] - minPrice > maxProfit)
				maxProfit = prices[i] - minPrice;
		}
		return maxProfit;
	}
}
