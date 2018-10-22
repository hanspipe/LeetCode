package leetCode;

//Given an array A of non-negative integers, 
//return an array consisting of all the even elements of A, 
//followed by all the odd elements of A.

public class Problem_905_SortArrayByParity {
	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 4 };
		sortArrayByParity(A);
		for (int i : A)
			System.out.print(i + " ");
	}

	public static int[] sortArrayByParity(int[] A) {
		int lo = 0;
		int hi = A.length - 1;
		while (lo < hi) {
			while (A[lo] % 2 == 0 && lo < hi)
				lo++;
			while (A[lo] % 2 == 1 && A[hi] % 2 == 0 && lo < hi) {
				swap(A, lo, hi);
			}
			hi--;
		}
		return A;
	}

	public static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;

	}
}
