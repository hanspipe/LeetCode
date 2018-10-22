package leetCode;

public class Problem_696_CountBinarySubstrings {
	
	public static void main(String[] args) {
		String str = "00110";
		System.out.println(countBinarySubstrings2(str));
	}
	
	public static int countBinarySubstrings(String s) {
		int res = 0;
		int prevRunLen = 0;
		int curRunLen = 1;
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == s.charAt(i-1))
				curRunLen++;
			else {
				prevRunLen = curRunLen;
				curRunLen = 1;
			}
			if(prevRunLen >= curRunLen)
				res++;
		}
		return res;
	}
	public static int countBinarySubstrings2(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				if (isValid(s.substring(i, j)))
					cnt++;
			}
		}
		return cnt;

	}

	private static boolean isValid(String str) {
		char[] arr = str.toCharArray();
		int n = arr.length;
		if (n % 2 != 0)
			return false;
		int l = 0;
		int r = n - 1;
		if (arr[0] == '1' && arr[n - 1] == '0') {
			while (l < r) {
				if (arr[l] == '1' && arr[r] == '0') {
					l++;
					r--;
				} else {
					return false;
				}
			}
			return true;
		} else if (arr[0] == '0' && arr[n - 1] == '1') {
			while (l < r) {
				if (arr[l] == '0' && arr[r] == '1') {
					l++;
					r--;
				} else {
					return false;
				}
			}
			return true;
		} else
			return false;

	}
}
