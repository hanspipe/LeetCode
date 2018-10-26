package leetCode;

/**
 * 
 * @author louis
 * 2018年10月26日
 * <p>Description:Given a 32-bit signed integer, reverse digits of an integer </p>
 * 有正有负，末尾有0时反转后要消掉
 */
public class Problem_007_ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(100));
	}

	public static int reverse(int x) {
		int res = 0;
		while(x != 0) {
			// 计算原数末尾值
			int tail = x % 10;
			// 
			int newRes = res * 10 + tail;
			// 如果上一步计算溢出了，下面的判断就为真，返回0
			if((newRes - tail) / 10 != res)
				return 0;
			// 更新res值
			res = newRes;
			x /= 10;
		}
		return res;
	}
}
