package leetCode;

/**
 * 
 * @author louis 2018年10月26日
 *         <p>
 * 		Description: An integer is a palindrome when it reads the same
 *         backward as forward.
 *         </p>
 *         是否回文数， 不转为String的方法
 */
public class Problem_009_PalindromeNumber {
	public boolean isPalindrome(int x) {

		// 负数和末尾为0而不为0的数直接返回false
		if (x < 0 || (x % 10 == 0 && x != 0))
			return false;

		// revertedNum用于记录后一半的反转
		int revertedNum = 0;
		while (x > revertedNum) {
			revertedNum = revertedNum * 10 + x % 10;
			x /= 10;
		}
		// x == revertedNum / 10 这个判断是因为循环跳出时revertedNum可能与x位数相同，也可能多一位，取决于原数是奇数位还是偶数位
		return x == revertedNum || x == revertedNum / 10;
	}
}
