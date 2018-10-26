package leetCode;

/**
 * 
 * @author louis 2018��10��26��
 *         <p>
 * 		Description: An integer is a palindrome when it reads the same
 *         backward as forward.
 *         </p>
 *         �Ƿ�������� ��תΪString�ķ���
 */
public class Problem_009_PalindromeNumber {
	public boolean isPalindrome(int x) {

		// ������ĩβΪ0����Ϊ0����ֱ�ӷ���false
		if (x < 0 || (x % 10 == 0 && x != 0))
			return false;

		// revertedNum���ڼ�¼��һ��ķ�ת
		int revertedNum = 0;
		while (x > revertedNum) {
			revertedNum = revertedNum * 10 + x % 10;
			x /= 10;
		}
		// x == revertedNum / 10 ����ж�����Ϊѭ������ʱrevertedNum������xλ����ͬ��Ҳ���ܶ�һλ��ȡ����ԭ��������λ����ż��λ
		return x == revertedNum || x == revertedNum / 10;
	}
}
