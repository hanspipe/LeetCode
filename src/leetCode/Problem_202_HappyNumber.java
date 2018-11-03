package leetCode;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author louis
 * 2018年11月4日
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
		
		while(set.add(n)) {// 每次将n加入set
			squareSum = 0;
			// 计算每位平方和
			while(n != 0) { 
				int remain = n % 10;
				squareSum += remain * remain;
				n /= 10;
			}
			if(squareSum == 1)
				return true;
			else// !=1就把上次的和赋给n, 继续循环
				n = squareSum;
		}
		// 如果n出现重复数字就说明进入了一个无限循环
		return false;
	}
}
