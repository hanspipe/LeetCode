package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Problem_771_JewelsandStones {
	public int numJewelsInStones(String J, String S) {
		char[] jArr = J.toCharArray();
		char[] sArr = S.toCharArray();
		int cnt = 0;
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < jArr.length; i++)
			set.add(jArr[i]);
		for(int i = 0; i < sArr.length; i++)
		{
			if(set.contains(sArr[i]))
				cnt++;
		}
		return cnt;
	}
}
