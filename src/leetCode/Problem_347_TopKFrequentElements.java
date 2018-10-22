package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_347_TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k){
		
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		
		for(int n : nums)
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		
		for(int key : frequencyMap.keySet()) {
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
