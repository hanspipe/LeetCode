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
		// lenA:����headA����
		while (pA != null) {
			pA = pA.next;
			lenA++;
		}
		// lenB:����headB����
		while (pB != null) {
			pB = pB.next;
			lenB++;
		}
		// pA��pB�����������β,�������������������뽻
		if (pA != pB)
			return null;
		else {
			//�ٽ�pA��pB��ֵΪ��Ӧͷ���
			pA = headA;
			pB = headB;
			// ���㳤�Ȳ�
			int diff = Math.abs(lenA - lenB);
			// ���headA��,��pA����diff��
			if (lenA >= lenB) {
				while (diff-- > 0) {
					pA = pA.next;
				}
				// Ȼ��һ����, һ��������
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
