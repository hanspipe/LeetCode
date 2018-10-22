package leetCode;

public class Problem_160_IntersectionOfTwoLinkedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode pA = headA;
		int lenA = 0;
		ListNode pB = headB;
		int lenB = 0;
		while (pA != null) {
			pA = pA.next;
			lenA++;
		}
		while (pB != null) {
			pB = pB.next;
			lenB++;
		}

		if (pA != pB)
			return null;
		else {
			pA = headA;
			pB = headB;
			int diff = Math.abs(lenA - lenB);
			if (lenA >= lenB) {
				while (diff-- > 0) {
					pA = pA.next;
				}
				while(pA != pB) {
					pA = pA.next;
					pB = pB.next;
				}
				return pA;
			}else {
				while (diff-- > 0) {
					pB = pB.next;
				}
				while(pA != pB) {
					pA = pA.next;
					pB = pB.next;
				}
				return pA;
			}
		}
	}
}
