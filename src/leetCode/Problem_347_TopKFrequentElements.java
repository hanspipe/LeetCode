package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author louis
 * 2018年11月4日
 * <p>Description: Given a non-empty array of integers, return the k most frequent elements.</p>
 */
public class Problem_347_TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k){
		
		@SuppressWarnings("unchecked")
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		
		// 将每个数及其对应的频率放入frequencyMap
		for(int n : nums)
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		// 遍历frequencyMap的key
		for(int key : frequencyMap.keySet()) {
			// 记录当前数的频率
			int frequency = frequencyMap.get(key);
			if(bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		
		List<Integer> res = new ArrayList<>();
		
		for(int i = bucket.length-1; i >=0 && res.size() < k; i--) {
			if(bucket[i] != null)
				res.addAll(bucket[i]);
		}
		
		return res;
	}
	
	
}
