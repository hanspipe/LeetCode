package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new
 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
 */
/**
 * 
 * @author louis
 * 2018年11月12日
 * <p>Description: Implement a MapSum class with insert, and sum methods.

	For the method insert, you'll be given a pair of (string, integer). 
	
	The string represents the key and the integer represents the value.
	
	 If the key already existed, then the original key-value pair will be overridden to the new one.

	For the method sum, you'll be given a string representing the prefix, 

	and you need to return the sum of all the pairs' value whose key starts with the prefix.</p>
 */
public class Problem_677_MapSumPairs {
	Map<String, Integer> map;

	/** Initialize your data structure here. */
	class MapSum{
		
		public MapSum() {
			map = new  HashMap<>();
		}
	}

	// insert操作直接put到map中
	public void insert(String key, int val) {
		map.put(key, val);
	}

	// sum
	public int sum(String prefix) {
		int res = 0;
		for (String s : map.keySet()) {
			// prefix长度要小于s
			// prefix.equals(s.substring(0, prefix.length())) : 判断是否为前缀
			if (prefix.length() <= s.length() && prefix.equals(s.substring(0, prefix.length())))
				res += map.get(s);
		}
		return res;
	}
}
