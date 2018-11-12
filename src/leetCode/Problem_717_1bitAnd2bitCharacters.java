package leetCode;

/**
 * 
 * @author louis
 * 2018Äê11ÔÂ12ÈÕ
 * <p>Description: We have two special characters. 
 * 
 * The first character can be represented by one bit 0. 
 * 
 * The second character can be represented by two bits (10 or 11).

	Now given a string represented by several bits. 

	Return whether the last character must be a one-bit character or not. 

	The given string will always end with a zero.</p>
 */
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
