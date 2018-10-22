package leetCode;
//A string S of lowercase letters is given.

import java.util.ArrayList;
import java.util.List;

//We want to partition this string into as many parts as possible so that each letter appears in at most one part,
//and return a list of integers representing the size of these parts.

/*
 * Input: S = "ababcbacadefegdehijhklij"
	Output: [9,7,8]
	Explanation:
	The partition is "ababcbaca", "defegde", "hijhklij".
 */
public class Problem_763_PartitionLabels {
	public List<Integer> partitionLabels(String S) {
		List<Integer> list = new ArrayList<>();
		int[] lastPos = new int[26];
		for (int i = 0; i < S.length(); i++)
			lastPos[S.charAt(i) - 'a'] = i;
		int lastCut = -1;
		int cut = -1;
		for (int i = 0; cut < S.length() - 1; i++) {
			cut = Math.max(cut, lastPos[S.charAt(i) - 'a']);
			if(cut == i) {
				list.add(cut - lastCut);
				lastCut = cut;
			}
		}
		if (cut > lastCut)
			list.add(cut - lastCut);
		return list;
	}
}
