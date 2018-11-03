package leetCode;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author louis
 * 2018��11��4��
 * <p>Description: A happy number is a number defined by the following process: 
 * 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * 
 *  and repeat the process until the number equals 1 (where it will stay), 
 *  
 *  or it loops endlessly in a cycle which does not include 1. 
 *  
 *  Those numbers for which this process ends in 1 are happy numbers.</p>
 */
public class Problem_202_HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int squareSum;
		
		while(set.add(n)) {// ÿ�ν�n����set
			squareSum = 0;
			// ����ÿλƽ����
			while(n != 0) { 
				int remain = n % 10;
				squareSum += remain * remain;
				n /= 10;
			}
			if(squareSum == 1)
				return true;
			else// !=1�Ͱ��ϴεĺ͸���n, ����ѭ��
				n = squareSum;
		}
		// ���n�����ظ����־�˵��������һ������ѭ��
		return false;
	}
}
