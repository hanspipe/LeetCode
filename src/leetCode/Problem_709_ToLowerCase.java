package leetCode;

public class Problem_709_ToLowerCase {
	public String toLowerCase(String str) {
		StringBuilder sb = new StringBuilder();
		char[] arr = str.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= 'A' && arr[i] <= 'Z') {
				sb.append((char)(arr[i] + 32));
			}else {
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}
}
