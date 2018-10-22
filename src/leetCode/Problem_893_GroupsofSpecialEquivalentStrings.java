package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem_893_GroupsofSpecialEquivalentStrings {
	public static void main(String[] args) {
		String[] test = {"aa","bb","ab","ba"};
		System.out.println(numSpecialEquivGroups(test));
	}
	public static int numSpecialEquivGroups(String[] A) {
		Set<String> set = new HashSet<>();
		for (String s : A) {
			int[] even = new int[26];
			int[] odd = new int[26];
			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 1)
					odd[s.charAt(i) - 'a']++;
				else
					even[s.charAt(i) - 'a']++;
			}
			String sig = Arrays.toString(odd) + Arrays.toString(even);
			set.add(sig);
		}
		return set.size();
	}
}
