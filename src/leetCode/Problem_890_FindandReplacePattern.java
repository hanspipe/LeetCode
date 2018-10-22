package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
	Output: ["mee","aqq"]
 */
public class Problem_890_FindandReplacePattern {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> list = new ArrayList<>();
		for (String w : words) {
			int[] s = new int[26];
			int[] p = new int[26];
			boolean same = true;
			for (int i = 0; i < w.length(); i++) {
				if (s[w.charAt(i) - 'a'] != p[pattern.charAt(i) - 'a']) {
					same = false;
					break;
				} else {
					s[w.charAt(i) - 'a'] = p[pattern.charAt(i) - 'a'] = i + 1;
				}
			}
			if (same)
				list.add(w);
		}
		return list;

	}

	public static boolean isMatchPattern(String[] words, String pattern) {
		char[] patternChars = pattern.toCharArray();
		boolean match = true;
		for (String word : words) {
			char[] wordChars = word.toCharArray();
			// 是否匹配
			// 用于存储映射关系的Map
			Map<Character, Character> map = new HashMap<>();
			for (int i = 0; i < patternChars.length; i++) {
				char p = patternChars[i];
				char w = wordChars[i];
				if (map.containsKey(p)) {// 模式中的字母是否已经映射已经被映射
					char value = map.get(p);
					if (value != w) {
						match = false;
						break;
					}
				} else {
					if (map.containsValue(w)) {// 判断单词中的字母是否被映射，防止模式多个字母都映射单词中的同一个字母
						match = false;
						break;
					} else
						map.put(p, w);
				}
			}
		}
		return match;
	}
}
