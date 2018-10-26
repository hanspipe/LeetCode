package leetCode;

/**
 * 
 * @author louis
 * 2018年10月26日
 * <p>Description: 最长公共前缀</p>
 */
public class Problem_014_LongestCommonPrefix {
	
	public static void main(String[] args) {
		String[] strs = {"flower","flow","foight"};
		System.out.println(longestCommonPrefix2(strs));
	}
	
	//Horizontal scanning
	public String longestCommonPrefix1(String[] strs) {
		if(strs.length == 0)
			return "";
		String prefix = strs[0];
		for(int i = 0; i < strs.length; i++)
		{
			// 如果str[i]不是以prefix为前缀
			while(strs[i].indexOf(prefix) != 0) {
				//就把prefix末尾减掉一位
				prefix = prefix.substring(0, prefix.length()-1);
				// 减到没有就返回
				if(prefix.isEmpty())
					return "";
			}
		}
		return prefix;
	}
	
	//Vertical scanning
	public static String longestCommonPrefix2(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		// 以String数组中第一个String为基准
		for(int i = 0; i < strs[0].length(); i++) {
			// 去str[0]的当前字符
			char c = strs[0].charAt(i);
			// 从String[] 的第二个String开始遍历,每个词遍历一位
			for(int j = 1; j < strs.length; j++) {
				// 如果i==当前String的长度或者当前String的第i位不!=c
				if(i == strs[j].length() || strs[j].charAt(i) != c)
					// 返回str[0]的0~i-1位
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
}
