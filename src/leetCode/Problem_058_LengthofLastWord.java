package leetCode;

public class Problem_058_LengthofLastWord {
	public int lengthOfLastWord(String s) {
		// ȥ��ͷβ�ո�
		s = s.trim();
		//���һ�����ʵĵ�һ���ַ���index
		int lastIndex = s.lastIndexOf(" ") + 1;
		return s.length() - lastIndex;
	}
}
