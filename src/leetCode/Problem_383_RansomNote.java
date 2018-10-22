package leetCode;

public class Problem_383_RansomNote {
	public static void main(String[] args) {
		System.out.println(canConstruct("aa", "aab"));
	}
	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] arrR = new int[26];
		int[] arrM = new int[26];
		for (char c : ransomNote.toCharArray())
			arrR[c - 'a']++;

		for (char c : magazine.toCharArray())
			arrM[c - 'a']++;
		
		for(int i = 0; i < 26; i ++) {
			if(arrM[i] < arrR[i])
				return false;
		}
		return true;
	}
}
