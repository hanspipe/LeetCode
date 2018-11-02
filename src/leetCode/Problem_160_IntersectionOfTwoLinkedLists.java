package leetCode;

//Write a program to find the node at which the intersection of two singly linked lists begins.
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
		// lenA:链表headA长度
		while (pA != null) {
			pA = pA.next;
			lenA++;
		}
		// lenB:链表headB长度
		while (pB != null) {
			pB = pB.next;
			lenB++;
		}
		// pA和pB是两个链表的尾,如果不相等则两个链表不想交
		if (pA != pB)
			return null;
		else {
			//再将pA和pB赋值为相应头结点
			pA = headA;
			pB = headB;
			// 计算长度差
			int diff = Math.abs(lenA - lenB);
			// 如果headA长,就pA先走diff步
			if (lenA >= lenB) {
				while (diff-- > 0) {
					pA = pA.next;
				}
				// 然后一起走, 一定会相遇
				while (pA != pB) {
					pA = pA.next;
					pB = pB.next;
				}
				return pA;
			} else {
				while (diff-- > 0) {
					pB = pB.next;
				}
				while (pA != pB) {
					pA = pA.next;
					pB = pB.next;
				}
				return pA;
			}
		}
	}
}
