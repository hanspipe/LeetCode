package leetCode;

/**
 * 
 * @author louis
 * 2018��11��2��
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
			// �� i�������һ��,�ҽ���۸��������,�ͺ���,��������ҵ���һ����ֵ
			while(i < prices.length - 1 && prices[i] >= prices[i + 1])
				i++;
			//vally:��ֵ
			vally = prices[i];
			// �� i�������һ��,�ҽ����ֵС������,�ͼ���ɨ,��������ҵ���һ����ֵ
			while(i < prices.length - 1 && prices[i] <= prices[i + 1])
				i++;
			// peak:��ֵ
			peak = prices[i];
			// peak - vally������һ�Է��֮������� ����ÿһ���������ĺ�
			maxProfit += peak - vally;
		}
		return maxProfit;
	}
}
