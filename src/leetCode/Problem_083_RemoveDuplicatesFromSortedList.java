package leetCode;
//Given a sorted linked list, delete all duplicates such that each element appear only once
public class Problem_083_RemoveDuplicatesFromSortedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode cur = head;
		//��ǰ�ڵ㲻Ϊ���ҵ�ǰ�ڵ����һ���ڵ㲻Ϊ��
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {//�����ǰ�ڵ�ֵ=��һ���ڵ�ֵ
				//ֻ�øı�cur.next
				cur.next = cur.next.next;
			}else {//���������
				cur = cur.next;
			}
		}
		return head;

	}
}
