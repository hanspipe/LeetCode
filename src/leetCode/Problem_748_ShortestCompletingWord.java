package leetCode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem_748_ShortestCompletingWord {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
	}
	public static String shortestCompletingWord(String licensePlate, String[] words) {
		int[] arr = new int[26]; 
		String res = "";
		Map<String, Integer> map = new LinkedHashMap<>();
		int min = Integer.MAX_VALUE;
		for(char c : licensePlate.toLowerCase().toCharArray()) {
			if(!Character.isLetter(c))
				continue;
			arr[c - 'a']++;
		}
		
		for(String word : words) {
			int[] wordArr = new int[26];
			for(char c : word.toLowerCase().toCharArray()) {
				wordArr[c - 'a']++;
			}
			if(isValid(arr, wordArr)) {
				map.put(word, word.length());
				min = word.length() < min ? word.length() : min;
			}
		}
		for(String s : map.keySet()) {
			if(map.get(s) == min) {
				res = s;
				break;
			}
		}
		return res;
	}
	
	private static boolean isValid(int[] plateArr, int[] wordArr) {
		for(int i = 0; i < 26; i++) {
			if(wordArr[i] < plateArr[i])
				return false;
		}
		return true;
	}
}
