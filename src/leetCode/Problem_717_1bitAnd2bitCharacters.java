package leetCode;

public class Problem_717_1bitAnd2bitCharacters {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 0 };
		System.out.println(isOneBitCharacter(arr));
	}

	public static boolean isOneBitCharacter(int[] bits) {
		int i = 0;
		while (i < bits.length) {
			if (bits[i] == 1)
				i += 2;
			else {
				if (i == bits.length - 1)
					return true;
				else
					i++;
			}
		}
		return false;
	}
}
