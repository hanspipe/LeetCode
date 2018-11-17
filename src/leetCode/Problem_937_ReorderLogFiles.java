package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author louis 2018年11月17日
 *         <p>
 *         Description: You have an array of logs. Each log is a space delimited
 *         string of words.
 * 
 *         For each log, the first word in each log is an alphanumeric
 *         identifier. Then, either:
 * 
 *         Each word after the identifier will consist only of lowercase
 *         letters, or;
 * 
 *         Each word after the identifier will consist only of digits.
 * 
 *         We will call these two varieties of logs letter-logs and digit-logs.
 *         It is guaranteed that each log has at least one word after its
 *         identifier.
 * 
 *         Reorder the logs so that all of the letter-logs come before any
 *         digit-log. The letter-logs are ordered lexicographically ignoring
 *         identifier, with the identifier used in case of ties. The digit-logs
 *         should be put in their original order.
 * 
 *         Return the final order of the logs.
 *         </p>
 */
public class Problem_937_ReorderLogFiles {
	public String[] reorderLogFiles(String[] logs) {
		// 自定义一个比较器
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 判断o1和o2是否为数字串, 只需判断第一个' '之后的那个字符
				boolean o1_IsDigit = Character.isDigit(o1.charAt(o1.indexOf(' ') + 1));
				boolean o2_IsDigit = Character.isDigit(o2.charAt(o2.indexOf(' ') + 1));
				// 都是数字串, 大小相等 , 维持原顺序
				if (o1_IsDigit && o2_IsDigit)
					return 0;
				// 数字串排在后面
				else if (!o1_IsDigit && o2_IsDigit)
					return -1;
				else if (o1_IsDigit && !o2_IsDigit)
					return 1;
				else // 比较第一个' '之后的子串大小, 自动就是字典序
					return o1.substring(o1.indexOf(' ') + 1).compareTo(o2.substring(o2.indexOf(' ') + 1));
			}
		};
		// 直接排序
		Arrays.sort(logs, cmp);
		return logs;
	}
}
