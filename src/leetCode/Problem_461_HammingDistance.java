package leetCode;
//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

//Given two integers x and y, calculate the Hamming distance.

public class Problem_461_HammingDistance {
	public int hammingDistance(int x, int y) {
		// �����ͬΪ0����ͬΪ1
		int n = x ^ y;
		// ����n�Ķ����Ʊ�ʾ��1�ĸ���
		int cnt = 0;
		while (n != 0) {
			cnt++;
			n = n & (n - 1);
		}
		return cnt;
	}
}
