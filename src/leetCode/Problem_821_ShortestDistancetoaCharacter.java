package leetCode;

import java.util.Arrays;

public class Problem_821_ShortestDistancetoaCharacter {
	public static void main(String[] args) {
		String S = "loveleetcode";
		char C = 'e';
		System.out.println(Arrays.toString(shortestToChar(S, C)));
	}

	public static int[] shortestToChar(String S, char C) {
		int N = S.length();
		int[] ans = new int[N];
		int prev = Integer.MIN_VALUE / 2;

		for (int i = 0; i < N; ++i) {
			if (S.charAt(i) == C)
				prev = i;
			ans[i] = i - prev;
		}

		prev = Integer.MAX_VALUE / 2;
		for (int i = N - 1; i >= 0; --i) {
			if (S.charAt(i) == C)
				prev = i;
			ans[i] = Math.min(ans[i], prev - i);
		}

		return ans;
	}
	
	public int[] shortestToChar2(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) res[i] = S.charAt(i) == C ? 0 : n;
        for (int i = 1; i < n; ++i) res[i] = Math.min(res[i], res[i - 1] + 1);
        for (int i = n - 2; i >= 0; --i) res[i] = Math.min(res[i], res[i + 1] + 1);
        return res;
    }

}
