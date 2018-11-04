package leetCode;
/**
 * 
 * @author louis
 * 2018��11��4��
 * <p>Description: Given an arbitrary ransom note string and another string containing letters from all the magazines, 
 * 
 * write a function that will return true if the ransom note can be constructed from the magazines ; 
 * 
 * otherwise, it will return false.

		Each letter in the magazine string can only be used once in your ransom note.</p>
 */
public class Problem_383_RansomNote {
	public static void main(String[] args) {
		System.out.println(canConstruct("aa", "aab"));
	}
	public static boolean canConstruct(String ransomNote, String magazine) {
		// ��������ֱ��¼������String��ÿ����ĸ���ֵĴ���
		int[] arrR = new int[26];
		int[] arrM = new int[26];
		for (char c : ransomNote.toCharArray())
			arrR[c - 'a']++;

		for (char c : magazine.toCharArray())
			arrM[c - 'a']++;
		
		// ���magazine��ÿ����ĸ���ֵĴ�������С��ransomNote��Ϊtrue
		for(int i = 0; i < 26; i ++) {
			if(arrM[i] < arrR[i])
				return false;
		}
		return true;
	}
}
