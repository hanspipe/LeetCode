package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_824_GoatLatin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(toGoatLatin(input));

	}

	public static String toGoatLatin(String S) {
		List<String> list = new ArrayList<>();
		String[] words = S.split(" ");
		String a = "a";
		for (int i = 0; i < words.length; i++) {
			String tmp = "";
			if (words[i].charAt(0) != 'a' && words[i].charAt(0) != 'e' && words[i].charAt(0) != 'i'
					&& words[i].charAt(0) != 'o' && words[i].charAt(0) != 'u' && words[i].charAt(0) != 'A'
					&& words[i].charAt(0) != 'E' && words[i].charAt(0) != 'I' && words[i].charAt(0) != 'O'
					&& words[i].charAt(0) != 'U') {
				tmp = words[i].substring(1) + words[i].charAt(0) + "ma";
			} else {
				tmp = words[i] + "ma";
			}
			list.add(tmp + a);
			a += "a";
		}
		String res = "";
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size() - 1)
				res = res + list.get(i) + " ";
			else
				res += list.get(i);
		}

		return res;
	}
}
