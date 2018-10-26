package leetCode;

/**
 * 
 * @author louis
 * 2018��10��26��
 * <p>Description: �����ǰ׺</p>
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
			// ���str[i]������prefixΪǰ׺
			while(strs[i].indexOf(prefix) != 0) {
				//�Ͱ�prefixĩβ����һλ
				prefix = prefix.substring(0, prefix.length()-1);
				// ����û�оͷ���
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
		// ��String�����е�һ��StringΪ��׼
		for(int i = 0; i < strs[0].length(); i++) {
			// ȥstr[0]�ĵ�ǰ�ַ�
			char c = strs[0].charAt(i);
			// ��String[] �ĵڶ���String��ʼ����,ÿ���ʱ���һλ
			for(int j = 1; j < strs.length; j++) {
				// ���i==��ǰString�ĳ��Ȼ��ߵ�ǰString�ĵ�iλ��!=c
				if(i == strs[j].length() || strs[j].charAt(i) != c)
					// ����str[0]��0~i-1λ
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
}
