package leetCode;

/*
 * Given a positive integer, output its complement number. 
 * The complement strategy is to flip the bits of its binary representation.
 */

/*
 * for example:
100110, its complement is 011001, the sum is 111111. 
So we only need get the min number large or equal to num, then do substraction
 */
public class Problem_476_NumberComplement {
	public int findComplement(int num) {
		int i = 0;
		int j = 0;

		while (i < num) {
			i += Math.pow(2, j);
			j++;
		}
		return i - num;
	}
}
