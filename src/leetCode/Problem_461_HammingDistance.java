package leetCode;
//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

//Given two integers x and y, calculate the Hamming distance.

public class Problem_461_HammingDistance {
	public int hammingDistance(int x, int y) {
		// 异或：相同为0，不同为1
		int n = x ^ y;
		// 计算n的二进制表示中1的个数
		int cnt = 0;
		while (n != 0) {
			cnt++;
			n = n & (n - 1);
		}
		return cnt;
	}
}
