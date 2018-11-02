package leetCode;

/**
 * 
 * @author louis
 * 2018年11月2日
 * <p>Description: Say you have an array for which the ith element is the price of a given stock on day i.

	Design an algorithm to find the maximum profit. 

	You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).</p>
 */
public class Problem_122_BestTimeToBuyAndSellStockII {
	
	// Peak Valley Approach
	public int maxProfit1(int[] prices) {
		int i = 0;
		int vally = prices[0];
		int peak = prices[0];
		int maxProfit = 0;
		while(i < prices.length - 1) {
			// 当 i不是最后一天,且今天价格大于明天,就后退,否则就是找到了一个谷值
			while(i < prices.length - 1 && prices[i] >= prices[i + 1])
				i++;
			//vally:谷值
			vally = prices[i];
			// 当 i不是最后一天,且今天的值小于明天,就继续扫,否则就是找到了一个峰值
			while(i < prices.length - 1 && prices[i] <= prices[i + 1])
				i++;
			// peak:峰值
			peak = prices[i];
			// peak - vally就是这一对峰谷之间的收益 计算每一个峰谷收益的和
			maxProfit += peak - vally;
		}
		return maxProfit;
	}
}
