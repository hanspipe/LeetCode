package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_819_MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		paragraph += ".";
		Set<String> banSet = new HashSet<>();
		for (String w : banned)
			banSet.add(w);
		Map<String, Integer> count = new HashMap<>();
		String ans = "";
		int ansFreq = 0;

		StringBuilder word = new StringBuilder();
		for (char c : paragraph.toCharArray()) {
			if (Character.isLetter(c))
				word.append(Character.toLowerCase(c));
			else if (word.length() > 0) {
				String finalWord = word.toString();
				if (!banSet.contains(finalWord)) {
					count.put(finalWord, count.getOrDefault(finalWord, 0) + 1);
					if (count.get(finalWord) > ansFreq) {
						ans = finalWord;
						ansFreq = count.get(finalWord);
					}
				}
				word = new StringBuilder();
			}
		}
		return ans;
	}
}
