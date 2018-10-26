package leetCode;

/**
 * 
 * @author louis
 * 2018��10��26��
 * <p>Description:Given a 32-bit signed integer, reverse digits of an integer </p>
 * �����и���ĩβ��0ʱ��ת��Ҫ����
 */
public class Problem_007_ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(100));
	}

	public static int reverse(int x) {
		int res = 0;
		while(x != 0) {
			// ����ԭ��ĩβֵ
			int tail = x % 10;
			// 
			int newRes = res * 10 + tail;
			// �����һ����������ˣ�������жϾ�Ϊ�棬����0
			if((newRes - tail) / 10 != res)
				return 0;
			// ����resֵ
			res = newRes;
			x /= 10;
		}
		return res;
	}
}
