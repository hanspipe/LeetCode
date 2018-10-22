package leetCode;

public class Problem_861_ScoreAfterFlippingMatrix {
	public int matrixScore(int[][] A) {
		int M = A.length, N = A[0].length;
		int res = (1 << (N - 1)) * M;
		for (int j = 1; j < N; j++) {
			int cur = 0;
			for (int i = 0; i < M; i++)
				cur += A[i][j] == A[i][0] ? 1 : 0;
			res += Math.max(cur, M - cur) * (1 << (N - j - 1));
		}
		return res;
	}
}
