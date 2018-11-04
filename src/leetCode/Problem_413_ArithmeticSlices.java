package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author louis
 * 2018年11月4日
 * <p>Description: A sequence of number is called arithmetic 
 * 
 * if it consists of at least three elements 
 * 
 * and if the difference between any two consecutive elements is the same.
 * 
 * 	判断数组中等差子数组的个数</p>
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

	// 功能函数:判断数组是否等差
	public static boolean isArithmetic(List<Integer> list) {
		if (list.size() < 3)
			return false;
		// diff公差
		int diff = list.get(1) - list.get(0);
		// 从第三个数开始
		for (int i = 2; i < list.size(); i++) {
			if (list.get(i) - list.get(i - 1) != diff)
				return false;
		}
		return true;
	}
}
