package leetCode;

public class Problem_868_BinaryGap {
	public static void main(String[] args) {
		System.out.println(binaryGap(8));
	}
	public static int binaryGap(int N) {
		String binatyStr = Integer.toBinaryString(N);
		char[] arr = binatyStr.toCharArray();
		int last = -1;
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == '1') {
				if(last != -1)
					max = max > i - last ?  max : i - last;
				last = i;
			}
		}
		return max;
	}
}
