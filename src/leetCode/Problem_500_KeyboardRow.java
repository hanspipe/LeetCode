package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			for(char c : strs[i].toCharArray()) {
				map.put(c, i);
			}
		}
		
		List<String> list = new ArrayList<>();
		for(String word : words) {
			int index = map.get(word.toUpperCase().charAt(0));
			for(char c : word.toUpperCase().toCharArray()) {
				if(map.get(c) != index) {
					index = -1;
					break;
				}
			}
			
			if(index != -1)
				list.add(word);
		}
		return list.toArray(new String[0]);
	} 
}
