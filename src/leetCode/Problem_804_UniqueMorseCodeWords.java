package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Problem_804_UniqueMorseCodeWords {
	public int uniqueMorseRepresentations(String[] words) {
		String[] alphabet = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
				"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		Set<String> set = new HashSet<>();
		for (String w : words) {
			StringBuilder str = new StringBuilder();
			for (char c : w.toCharArray()) {
				c -= 97;
				str.append(alphabet[c]);
			}
			set.add(str.toString());
		}
		return set.size();
	}
}
