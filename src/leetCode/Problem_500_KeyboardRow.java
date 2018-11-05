package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author louis
 * 2018��11��5��
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
			// ��pattern������Ӧ�ı�ż���map
			for(char c : strs[i].toCharArray()) {
				map.put(c, i);
			}
		}
		
		List<String> list = new ArrayList<>();
		for(String word : words) {
			// index: ��ǰ���ʵ�һ����ĸ��Ӧ���Ǹ�pattern��
			int index = map.get(word.toUpperCase().charAt(0));
			for(char c : word.toUpperCase().toCharArray()) {
				// �ж��Ƿ�ÿһ����ĸ���ڵ�ǰpattern��, ���Ǿ�index=-1
				if(map.get(c) != index) {
					index = -1;
					break;
				}
			}
			// index!=-1�ļ�������
			if(index != -1)
				list.add(word);
		}
		return list.toArray(new String[0]);
	} 
}
