package leetCode;
/**
 * 
 * @author louis
 * 2018年11月2日
 * <p>Description: Say you have an array for which the ith element is the price of a given stock on day i.

	If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
	
	design an algorithm to find the maximum profit.

	Note that you cannot sell a stock before you buy one.</p>
 */
public class Problem_121_BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		// We need to find the largest peak following the smallest valley
		// 我们要找到最低价后面的最高价
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0; 
		for(int i = 0; i < prices.length; i++) {
			// 先找最低价
			if(prices[i] < minPrice)
				minPrice = prices[i];
			// 再更新最大利润
			else if(prices[i] - minPrice > maxProfit)
				maxProfit = prices[i] - minPrice;
		}
		return maxProfit;
	}
}
