package leetCode;

public class Problem_806_NumberofLinesToWriteString {
	public int[] numberOfLines(int[] widths, String S) {
		int res = 1; 
		int cur = 0;
		for(char c : S.toCharArray()) {
			int width = widths[c - 'a'];
			res = cur + width > 100 ? res + 1 : res;
			cur = cur + width > 100 ? width : cur + width;
		}
		return new int[] {res, cur};
	}
}
