package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author louis
 * 2018年11月5日
 * <p>Description: Given a List of words, 
 * 
 * 	return the words that can be typed using letters of alphabet 
 * 
 * 	on only one row's of American keyboard like the image below.</p>
 */
public class Problem_500_KeyboardRow {
	
	public static void main(String[] args) {
		String[] ws = {"Hello", "Alaska", "Dad", "Peace"};
		String[] res = findWords(ws);
		for(String s : res) {
			System.out.print(s);
		}
	}
	public static String[] findWords(String[] words) {
		String[] strs = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < strs.length; i++) {
			// 把pattern和它对应的编号加入map
			for(char c : strs[i].toCharArray()) {
				map.put(c, i);
			}
		}
		
		List<String> list = new ArrayList<>();
		for(String word : words) {
			// index: 当前单词第一个字母对应在那个pattern中
			int index = map.get(word.toUpperCase().charAt(0));
			for(char c : word.toUpperCase().toCharArray()) {
				// 判断是否每一个字母都在当前pattern中, 不是就index=-1
				if(map.get(c) != index) {
					index = -1;
					break;
				}
			}
			// index!=-1的加入结果集
			if(index != -1)
				list.add(word);
		}
		return list.toArray(new String[0]);
	} 
}
