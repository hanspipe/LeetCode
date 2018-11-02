package leetCode;
/**
 * 
 * @author louis
 * 2018��11��2��
 * <p>Description: Say you have an array for which the ith element is the price of a given stock on day i.

	If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
	
	design an algorithm to find the maximum profit.

	Note that you cannot sell a stock before you buy one.</p>
 */
public class Problem_121_BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		// We need to find the largest peak following the smallest valley
		// ����Ҫ�ҵ���ͼۺ������߼�
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0; 
		for(int i = 0; i < prices.length; i++) {
			// ������ͼ�
			if(prices[i] < minPrice)
				minPrice = prices[i];
			// �ٸ����������
			else if(prices[i] - minPrice > maxProfit)
				maxProfit = prices[i] - minPrice;
		}
		return maxProfit;
	}
}
