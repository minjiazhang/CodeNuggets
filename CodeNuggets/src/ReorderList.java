
public class ReorderList {
    public ListNode reorderList(ListNode head) {
        
        if (head == null || head.next == null || head.next.next == null) {
            return head; //TODO: handle just two nodes.
        }
        
        ListNode cur = head;
        
        ListNode right = splitFrontEnd(head); // (not find middle because we want to set the last node of the left half point to null)

		System.out.println(" head list ");

//		while (head != null) {
//			System.out.println("$ node: " + head.val);
//			head = head.next;
//		}
        
        right = reverse(right);
        
//		while (right != null) {
//			System.out.println("% node: " + right.val);
//			right = right.next;
//		}
        
        head = combine(head, right); 
        
        return head;
        //The following solution is suboptimal and can cause TLE.
        // ListNode tail = null;
        // while (cur != null) {
        //     if (cur.next == null) {
        //         break;
        //     }
        //     tail = getTail(cur); //Use recursion or stack.
        //     tail.next = cur.next; //tail.next is always null.
        //     cur.next = tail;
        //     cur = tail.next;
        // }
        
    }
    
    ListNode combine(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int i = 0;
        while (left != null && right != null) {
            if (i % 2 == 0) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
            i++;
        }
        
        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }
        
        return dummy.next;
    }
    
    ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }
    
    ListNode splitFrontEnd(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }
        
        ListNode left = slow.next;
        slow.next = null;
        return left;
    }
    
    public static void main(String[] args) {
    	ReorderList s = new ReorderList();
    	int[] list = new int[]{1, 2, 3};
    	ListNode head = s.reorderList(new List(list).head);
    	System.out.println("Finished" + head);
    	while (head != null) {
    		System.out.println(" node: " + head.val);
    		head = head.next;
    	}
    	
    }}
