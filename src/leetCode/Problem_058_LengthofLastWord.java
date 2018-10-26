package leetCode;

public class Problem_058_LengthofLastWord {
	public int lengthOfLastWord(String s) {
		// 去掉头尾空格
		s = s.trim();
		//最后一个单词的第一个字符的index
		int lastIndex = s.lastIndexOf(" ") + 1;
		return s.length() - lastIndex;
	}
}
