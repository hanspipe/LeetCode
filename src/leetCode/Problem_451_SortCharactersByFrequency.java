package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author louis
 * 2018年11月4日
 * <p>Description: Given a string, sort it in decreasing order based on the frequency of characters.</p>
 */
public class Problem_451_SortCharactersByFrequency {
	public String frequencySort(String s) {
		char[] arr = s.toCharArray();

		int[] count = new int[256];
		// 记录每个字符出现的次数
		for (char c : arr)
			count[c]++;

		// count values and their corresponding letters
		Map<Integer, List<Character>> map = new HashMap<>();
		for (int i = 0; i < 256; i++) {
			if (count[i] == 0)
				continue;
			// 
			int cnt = count[i];
			if (!map.containsKey(cnt))
				map.put(cnt, new LinkedList<Character>());
			map.get(cnt).add((char) i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int cnt = arr.length; cnt > 0; cnt--) {
			if(!map.containsKey(cnt))
				continue;
			List<Character> list = map.get(cnt);
			for(Character c : list)
				for(int i = 0; i < cnt; i--)
					sb.append(c);
		}
		return sb.toString();
	}
}
