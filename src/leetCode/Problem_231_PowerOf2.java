package leetCode;
/**
 * 
 * @author louis
 * 2018年11月4日
 * <p>Description: Given an integer, write a function to determine if it is a power of two.</p>
 */
public class Problem_231_PowerOf2 {
	public boolean isPowerOfTwo(int n) {
		// 如果是2的次幂, 二进制表示中肯定有且仅有一个1
		return n > 0 && Integer.bitCount(n) == 1;
	}
	
	//iterative
	public boolean isPowerOfTwo1(int n) {
		if(n == 0)
			return false;
		while(n % 2 == 0)
			n /= 2;
		// 判断跳出循环的时候n是否是1
		return n == 1;
	}
}
