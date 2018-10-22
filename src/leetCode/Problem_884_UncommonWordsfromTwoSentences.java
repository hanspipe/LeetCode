package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem_884_UncommonWordsfromTwoSentences {
	public static void main(String[] args) {
		
	}
	
	public String[] uncommonFromSentences(String A, String B) {
		List<String> list = new ArrayList<>();
        String[] arrA = A.split(" ");
        String[] arrB = B.split(" ");
        
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        
        for(String word : arrA) {
        	if(mapA.containsKey(word))
        		mapA.put(word, mapA.get(word)+1);
        	else
        		mapA.put(word, 1);
        }
        for(String word : arrB){
        	if(mapB.containsKey(word))
        		mapB.put(word, mapB.get(word)+1);
        	else
        		mapB.put(word, 1);
        }
        
        for(String s : mapA.keySet()) {
        	if(mapA.get(s) == 1 && !mapB.containsKey(s))
        		list.add(s);
        }
        for(String s : mapB.keySet()) {
        	if(mapB.get(s) == 1 && !mapA.containsKey(s))
        		list.add(s);
        }
        
        String[] res =  list.toArray(new String[list.size()]);
        
        return res;
        
    }
}
