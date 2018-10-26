package leetCode;

//Implement int sqrt(int x)
public class Problem_069_Sprt {
	public int mySqrt(int x) {
		if (x == 0)
			return 0;
		int left = 1, right = Integer.MAX_VALUE;
		while (true) {
			//���ַ�
			int mid = left + (right - left) / 2;
			//mid*mid�������
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				//Ҫ�� mid*mid < x < (mid+1)*(mid+1)
				if (mid + 1 > x / (mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}
}
