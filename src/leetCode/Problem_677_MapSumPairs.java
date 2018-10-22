package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new
 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
 */
public class Problem_677_MapSumPairs {
	Map<String, Integer> map;

	/** Initialize your data structure here. */
	class MapSum{
		
		public MapSum() {
			map = new  HashMap<>();
		}
	}

	public void insert(String key, int val) {
		map.put(key, val);
	}

	public int sum(String prefix) {
		int res = 0;
		for (String s : map.keySet()) {
			if (prefix.length() <= s.length() && prefix.equals(s.substring(0, prefix.length())))
				res += map.get(s);
		}
		return res;
	}
}
