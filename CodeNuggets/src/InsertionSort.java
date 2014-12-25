public class InsertionSort {
	public ListNode insertionSortList(ListNode head) {
		ListNode cur = head; // iterate the entire linked list nodes.
		ListNode temp = head; // used for checking all nodes before the current
								// node.
		ListNode prev = head;

		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummyHead = new ListNode(Integer.MIN_VALUE); // It is easier if
																// you first
																// create a
																// dummy node
																// for the head;
		ListNode newCur = null; // Track the current node of the new list.
//		ListNode prev = null;
		while (cur != null) {
			newCur = dummyHead; // Track the current node of the new list.
			prev = newCur;
			while (cur.val > newCur.val) {

				prev = newCur;
				newCur = newCur.next;

				if (newCur == null) {
					break;
				} else if (newCur.val > cur.val) {
					break;
				}
			}

			ListNode newNode = new ListNode(cur.val);
			newNode.next = newCur;
			prev.next = newNode;

			cur = cur.next;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class List {
	ListNode head;

	List(int[] data) {
		ListNode dummy = new ListNode(0);
		if (data != null) {
			
			ListNode cur = dummy;
			int len = data.length;
			for (int i = 0; i < len; i++) {
				ListNode ln = new ListNode(data[i]);
				cur.next = ln;
				cur = cur.next;
			}
		}
		head = dummy.next;
	}
}
