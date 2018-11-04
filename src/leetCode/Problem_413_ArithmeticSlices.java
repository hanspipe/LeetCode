package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author louis
 * 2018��11��4��
 * <p>Description: A sequence of number is called arithmetic 
 * 
 * if it consists of at least three elements 
 * 
 * and if the difference between any two consecutive elements is the same.
 * 
 * 	�ж������еȲ�������ĸ���</p>
 */
public class Problem_413_ArithmeticSlices {
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
			input.add(sc.nextInt());
		int[] arr = new int[input.size()];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = input.get(i);
		}
		
		System.out.println(numberOfArithmeticSlices(arr));
	}
	public static  int numberOfArithmeticSlices(int[] A) {
		int cnt = 0;
		int n = A.length;
		List<Integer> list = new ArrayList<>();
		for(int num : A)
			list.add(num);
		
		for (int i = 0; i < n - 2; i++) {
			for(int j = i; j < n; j++) {
				if(isArithmetic(list.subList(i, j+1)))
					cnt++;
			}
		}
		return cnt;
	}

	// ���ܺ���:�ж������Ƿ�Ȳ�
	public static boolean isArithmetic(List<Integer> list) {
		if (list.size() < 3)
			return false;
		// diff����
		int diff = list.get(1) - list.get(0);
		// �ӵ���������ʼ
		for (int i = 2; i < list.size(); i++) {
			if (list.get(i) - list.get(i - 1) != diff)
				return false;
		}
		return true;
	}
}
