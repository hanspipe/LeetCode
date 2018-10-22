package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Problem_817_LinkedListComponents {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public int numComponents(ListNode head, int[] G) {
		int cnt = 0;
		Set<Integer> set = new HashSet<>();
		for(int num : G)
			set.add(num);
		
		ListNode cur = head;
		while(cur != null ) {
			if(set.contains(cur.val) && (!set.contains(cur.next.val) || cur.next == null))
				cnt++;
			cur = cur.next;
		}
		return cnt;
	}
}
