package leetCode;
/**
 * 
 * @author louis
 * 2018年11月4日
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
		// 两个数组分别记录了两个String中每个字母出现的次数
		int[] arrR = new int[26];
		int[] arrM = new int[26];
		for (char c : ransomNote.toCharArray())
			arrR[c - 'a']++;

		for (char c : magazine.toCharArray())
			arrM[c - 'a']++;
		
		// 如果magazine中每个字母出现的次数都不小于ransomNote就为true
		for(int i = 0; i < 26; i ++) {
			if(arrM[i] < arrR[i])
				return false;
		}
		return true;
	}
}
