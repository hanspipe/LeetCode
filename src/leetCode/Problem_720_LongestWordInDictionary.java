package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Problem_720_LongestWordInDictionary {
	public String longestWord(String[] words) {
		String ans = "";
		Set<String> wordSet = new HashSet<>();
		for (String word : words)
			wordSet.add(word);
		for (String word : words) {
			if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
				boolean good = true;
				for (int k = 1; k < word.length(); ++k) {
                    if (!wordSet.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
				if(good)
					ans = word;
			}
		}
		return ans;
	}
}
