package leetCode;
/**
 * 
 * @author louis
 * 2018��11��4��
 * <p>Description: Given an integer, write a function to determine if it is a power of two.</p>
 */
public class Problem_231_PowerOf2 {
	public boolean isPowerOfTwo(int n) {
		// �����2�Ĵ���, �����Ʊ�ʾ�п϶����ҽ���һ��1
		return n > 0 && Integer.bitCount(n) == 1;
	}
	
	//iterative
	public boolean isPowerOfTwo1(int n) {
		if(n == 0)
			return false;
		while(n % 2 == 0)
			n /= 2;
		// �ж�����ѭ����ʱ��n�Ƿ���1
		return n == 1;
	}
}
